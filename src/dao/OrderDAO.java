package dao;

import common.DatabaseConnector;
import entities.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {

    public static void insert(Order order) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, order.getOrderID());
            ps.setDate(2, order.getOderDate());
            ps.setInt(3, order.getCustomerID());
            ps.setInt(4, order.getEmployeeID());
            ps.setDouble(5, order.getTotal());
            int row = ps.executeUpdate();
            System.out.println("Insert order successfully: " + row + " row inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Order order) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE Orders SET order_date = ?, customer_id = ?, employee_id = ?, total = ? WHERE order_id = ?");
            ps.setDate(1, order.getOderDate());
            ps.setInt(2, order.getOrderID());
            ps.setInt(3, order.getEmployeeID());
            ps.setDouble(4, order.getTotal());
            ps.setInt(5, order.getOrderID());
            int row = ps.executeUpdate();
            System.out.println("Update order successfully: " + row + " rows updated");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Orders WHERE order_id = ?");
            ps.setInt(1, ID);
            int row = ps.executeUpdate();
            System.out.println("Delete order successfully: " + row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> selectAll() {
        ArrayList<Order> result = new ArrayList<Order>();
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Orders");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                Date order_date = rs.getDate("order_date");
                int customer_id = rs.getInt("customer_id");
                int employee_id = rs.getInt("employee_id");
                int total = rs.getInt("total");

                Order order = new Order(order_id, order_date, customer_id, employee_id, total);
                result.add(order);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Order selectById(int ID) {
        Order result = null;
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Orders WHERE order_id = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                Date order_date = rs.getDate("order_date");
                int customer_id = rs.getInt("customer_id");
                int employee_id = rs.getInt("employee_id");
                int total = rs.getInt("total");

                result = new Order(order_id, order_date, customer_id, employee_id, total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
