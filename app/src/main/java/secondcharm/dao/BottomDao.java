package secondcharm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import secondcharm.Models.Bottom;

public class BottomDao {
    private static final String DB_URL = "jdbc:sqlite:db/bottoms.db";

    public ObservableList<Bottom> getBottomList() {
        ObservableList< Bottom> bots = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM bottom");
             ResultSet resultSet = prepStmt.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                byte[] image = resultSet.getBytes("image");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int size = resultSet.getInt("size");
                String describe = resultSet.getString("description");

                Bottom bottom = new Bottom(image, name, price, size, describe, id);
                bots.add(bottom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bots;
    }

    public void deleteFromDatabase(Bottom bottom) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM bottom WHERE id = ?")) {
            prepStmt.setInt(1, bottom.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}