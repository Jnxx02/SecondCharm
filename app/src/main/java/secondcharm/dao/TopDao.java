package secondcharm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import secondcharm.Models.Top;


public class TopDao {
    private static final String DB_URL = "jdbc:sqlite:db/tops.db";
    
    private static Connection conn;
    private static PreparedStatement prepStmt;
    private static ResultSet resultSet;
    private static String query;

    public TopDao() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Top> getAll() throws SQLException {
        List<Top> tops = new ArrayList<>();

        query = "SELECT * FROM tops";

        prepStmt = conn.prepareStatement(query);
        resultSet = prepStmt.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            int stock = resultSet.getInt("stock");
            // String imagePath = resultSet.getString("image_path");
            // String description = resultSet.getString("description");
            String size = resultSet.getString("size");

            Top top = new Top(name, price, stock, size);
            tops.add(top);
        }

        resultSet.close();
        prepStmt.close();

        return tops;
    }

}
