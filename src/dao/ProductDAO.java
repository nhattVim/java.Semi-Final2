package dao;

import common.DatabaseConnector;
import entities.Order;
import entities.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {

    public static void insert(Product product) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "INSERT INTO Product VALUES (" + product.getProductID() +", '" + product.getProductName() +"', '" + product.getListPrice()+ "')";
            int row = st.executeUpdate(sql);
            System.out.println("Insert product successfully: " + sql);
            System.out.println(row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Product product) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "UPDATE Product SET product_name = '" + product.getProductName() + "', list_price = '" + product.getListPrice() + "' WHERE product_id = " + product.getProductID();
            int row = st.executeUpdate(sql);
            System.out.println("Update product successfully: " + sql);
            System.out.println(row + " rows updated");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "DELETE FROM Product WHERE product_id = " + ID;
            int row = st.executeUpdate(sql);
            System.out.println("Delete product successfully: " + sql);
            System.out.println(row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> selectAll() {
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Product";
            ResultSet rs = st.executeQuery(sql);
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
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Orders WHERE product_id = " + ID;
            ResultSet rs = st.executeQuery(sql);
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

    public static ArrayList<Product> selectByCondition(String condition) {
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Product WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);
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
}
