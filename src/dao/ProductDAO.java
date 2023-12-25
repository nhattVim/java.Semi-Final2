package dao;

import common.DatabaseConnector;
import entities.Order;
import entities.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    public static void insert(Product product) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO Product VALUES (?, ?, ?)");
            ps.setInt(1, product.getProductID());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getListPrice());
            int row = ps.executeUpdate();
            System.out.println("Insert product successfully: " + row + " row inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Product product) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE Product SET product_name = ?, list_price = ? WHERE product_id = ?");
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getListPrice());
            ps.setInt(3, product.getProductID());
            int row = ps.executeUpdate();
            System.out.println("Update product successfully: " + row + " rows updated");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Product WHERE product_id = ?");
            ps.setInt(1, ID);
            int row = ps.executeUpdate();
            System.out.println("Delete product successfully: " + row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> selectAll() {
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                double list_price = rs.getDouble("list_price");

                result.add(new Product(product_id, product_name, list_price));
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Product selectById(int ID) {
        Product result = null;
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Product WHERE product_id = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                double list_price = rs.getDouble("list_price");

                result = new Product(product_id, product_name, list_price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
