package secondcharm.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import secondcharm.Models.Top;
import secondcharm.Utils.DataBaseConfig;

public class TopDao {
    private Connection conn;
    private Statement stmt;

    public TopDao() {
        conn = DataBaseConfig.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, "clothes", null);
            if (!rs.next()) {
                stmt = conn.createStatement();
                String sql = "CREATE TABLE clothes " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " name TEXT NOT NULL, " +
                        " price DOUBLE NOT NULL, " +
                        " stock INTEGER NOT NULL)" +
                        " size TEXT NOT NULL";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Top> getAll() throws SQLException {
        try {
            List<Top> listAtasan = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clothes");
            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                String size = rs.getString("size");
                listAtasan.add(new Top(name, price, stock, size));
            }
            return listAtasan;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<Top> listAtasan) {
        try {
            stmt.executeUpdate("DELETE from clothes");
            stmt = conn.createStatement();
            for (Top atasan : listAtasan) {
                String sql = String.format("""
                        INSERT INTO clothes(name, price, stock, size)
                        VALUES('%s', '%f', '%d', '%s');
                        """,
                        atasan.getName(),
                        atasan.getPrice(),
                        atasan.getStock(),
                        atasan.getSize());
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
