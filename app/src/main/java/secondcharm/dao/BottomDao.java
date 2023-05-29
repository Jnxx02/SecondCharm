package secondcharm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BottomDao {
    private static final String DB_URL = "jdbc:sqlite:db/tops.db";
    
    private static Connection conn;
    private static PreparedStatement prepStmt;
    private static ResultSet resultSet;
    private static String query;

    public BottomDao() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
