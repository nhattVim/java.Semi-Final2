package dao;

import common.DatabaseConnector;
import entities.Employee;
import entities.LineItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LineItemDAO {

    public static void insert(LineItem lineItem) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO LineItem VALUES (?, ?, ?, ?)");
            ps.setInt(1, lineItem.getOrderID());
            ps.setInt(2, lineItem.getProductID());
            ps.setInt(3, lineItem.getQuantity());
            ps.setDouble(4, lineItem.getPrice());
            int row = ps.executeUpdate();
            System.out.println("Insert line successfully: " + row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(LineItem lineItem) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE LineItem SET quantity = ?, price = ? WHERE order_id = ? AND product_id = ?");
            ps.setInt(1, lineItem.getQuantity());
            ps.setDouble(2, lineItem.getPrice());
            ps.setInt(3, lineItem.getOrderID());
            ps.setInt(4, lineItem.getProductID());
            int row = ps.executeUpdate();
            System.out.println("Update line successfully: " + row + " row updated");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int orderID, int productID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM LineItem WHERE order_id = ? AND  product_id = ?");
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            int row = ps.executeUpdate();
            System.out.println("Delete line successfully: " + row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LineItem> selectAll() {
        ArrayList<LineItem> result = new ArrayList<LineItem>();
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM LineItem");
            ResultSet rs = ps.executeQuery();
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
            PreparedStatement ps = c.prepareStatement("SELECT * FROM LineItem WHERE order_id = ? AND product_id = ?");
            ps.setInt(1, oderID);
            ps.setInt(2, productID);
            ResultSet rs = ps.executeQuery();
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
}
