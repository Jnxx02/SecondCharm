package secondcharm.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConfig {
    private static final String DB_URL = "jdbc:sqlite:db/user.db";

    private static Connection conn;
    private static PreparedStatement prepStmt;
    private static ResultSet resultSet;
    private static String query;

    public static void connection() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean validasiLogin(String username, String password) {
        connection();
        query = "SELECT username, password FROM user WHERE username=? AND password=?";

        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);

            try (ResultSet login = prepStmt.executeQuery()) {
                return login.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isUsernameAvailable(String username) {
        connection();
        query = "SELECT username FROM user WHERE username=?";

        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, username);

            try (ResultSet signUp = prepStmt.executeQuery()) {
                return !signUp.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerUser(String username, String password) {
        connection();
        query = "INSERT INTO user (username, password) VALUES (?, ?)";

        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);

            int rowsInserted = prepStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
