package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.Producto;

public class ProductoDaoImpl implements ProductDao {

   

    String dropTableSQL = "drop table if exists productos";
    String createTableSQL = "create table if not exists productos(" +
            "id serial," +
            "name VARCHAR(255), " +
            "price VARCHAR(255), " +
            "category DOUBLE PRECISION, " +
            "brand VARCHAR(255), " +
            "stock INT, " +
            "PRIMARY KEY (id)" +
            ")";

    @Override
    public boolean insert(Producto producto) {
        String insertSQL = "insert into productos(name,price,category,brand,stock) values (?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement pss = conn.prepareStatement(insertSQL)) {

            pss.setString(1, producto.getName());
            pss.setString(2, producto.getPrice());
            pss.setDouble(3, producto.getCategory());
            pss.setString(4, producto.getBrand());
            pss.setInt(5, producto.getStock());
            pss.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        String deleteSQL = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement pss = conn.prepareStatement(deleteSQL)) {

            pss.setLong(1, id);
            pss.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Producto producto) {
        String updateSQL = "update productos set name = ?, price = ?, category = ?, brand = ?, stock = ? where id = ?";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement pss = conn.prepareStatement(updateSQL)) {

            pss.setString(1, producto.getName());
            pss.setString(2, producto.getPrice());
            pss.setDouble(3, producto.getCategory());
            pss.setString(4, producto.getBrand());
            pss.setInt(5, producto.getStock());
            pss.setLong(6, producto.getId());
            pss.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Producto find(Long id) {
        String findSQL = "SELECT * FROM productos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement pss = conn.prepareStatement(findSQL)) {

            pss.setLong(1, id);
            ResultSet rs = pss.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Producto> findall() {
        String findSQL = "SELECT * FROM productos";

        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement pss = conn.prepareStatement(findSQL)) {

            ResultSet rs = pss.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean createTable() {
        try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
             PreparedStatement drop = conn.prepareStatement(dropTableSQL);
             PreparedStatement create = conn.prepareStatement(createTableSQL)) {

            drop.executeUpdate();
            create.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	
	
}