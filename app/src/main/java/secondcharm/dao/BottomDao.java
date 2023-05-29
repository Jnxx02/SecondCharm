package secondcharm.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import secondcharm.Models.Bottom;
import secondcharm.Utils.DataBaseConfig;

public class BottomDao {
    private Connection conn;
    private Statement stmt;

    public BottomDao() {
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
                        " size INTEGER NOT NULL";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bottom> getAll() throws SQLException {
        try {
            List<Bottom> listBawahan = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clothes");
            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                int size = rs.getInt("size");
                listBawahan.add(new Bottom(name, price, stock, size));
            }
            return listBawahan;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<Bottom> listBawahan) {
        try {
            stmt.executeUpdate("DELETE from clothes");
            stmt = conn.createStatement();
            for (Bottom bawahan : listBawahan) {
                String sql = String.format("""
                        INSERT INTO clothes(name, price, stock, size)
                        VALUES('%s', '%f', '%d', '%d');
                        """,
                        bawahan.getName(),
                        bawahan.getPrice(),
                        bawahan.getStock(),
                        bawahan.getSize());
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
