package secondcharm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import secondcharm.Models.Top;

public class TopDao {
    private static final String DB_URL = "jdbc:sqlite:db/tops.db";

    public ObservableList<Top> getToplList() {
        ObservableList<Top> tops = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM top");
             ResultSet resultSet = prepStmt.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                byte[] image = resultSet.getBytes("image");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String size = resultSet.getString("size");
                String describe = resultSet.getString("description");

                Top top = new Top(image, name, price, size, describe, id);
                tops.add(top);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tops;
    }

    public void deleteFromDatabase(Top top) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement prepStmt = conn.prepareStatement("DELETE * FROM top WHERE id = ?")) {
            prepStmt.setInt(1, top.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}