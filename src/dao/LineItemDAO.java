package dao;

import common.DatabaseConnector;
import entities.Employee;
import entities.LineItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LineItemDAO {

    public static void insert(LineItem lineItem) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "INSERT INTO LineItem VALUES (" + lineItem.getOrderID() + ", " + lineItem.getProductID() + ", " + lineItem.getQuantity() + ", " + lineItem.getPrice() + ")";
            int row = st.executeUpdate(sql);
            System.out.println("Insert line successfully: " + sql);
            System.out.println(row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(LineItem lineItem) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "UPDATE LineItem SET quantity = " + lineItem.getQuantity() + ", price = " + lineItem.getPrice() + " WHERE order_id = " + lineItem.getOrderID() + " AND product_id = " + lineItem.getProductID();
            int row = st.executeUpdate(sql);
            System.out.println("Update line successfully: " + sql);
            System.out.println(row + " rows updated");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int orderID, int productID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "DELETE FROM LineItem WHERE order_id = " + orderID + " AND product_id = " + productID;
            int row = st.executeUpdate(sql);
            System.out.println("Delete line successfully: " + sql);
            System.out.println(row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LineItem> selectAll() {
        ArrayList<LineItem> result = new ArrayList<LineItem>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM LineItem";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                LineItem lineItem = new LineItem(order_id, product_id, quantity, price);
                result.add(lineItem);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static LineItem selectById(int oderID, int productID) {
        LineItem result = null;
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM LineItem WHERE order_id = " + oderID + " AND product_id = " + productID;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                result = new LineItem(order_id, product_id, quantity, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<LineItem> selectByCondition(String condition) {
        ArrayList<LineItem> result = new ArrayList<LineItem>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM LineItem WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                LineItem lineItem = new LineItem(order_id, product_id, quantity, price);
                result.add(lineItem);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
