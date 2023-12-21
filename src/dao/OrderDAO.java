package dao;

import common.DatabaseConnector;
import entities.LineItem;
import entities.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {

    public static void insert(Order order) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "INSERT INTO Orders VALUES (" + order.getOrderID() + ", '" + order.getOderDate()+ "', " + order.getCustomerID() + ", " + order.getEmployeeID() + ", " + order.getTotal() + ")";
            int row = st.executeUpdate(sql);
            System.out.println("Insert order successfully: " + sql);
            System.out.println(row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Order order) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "UPDATE Orders SET order_date='" + order.getOderDate() + "', customer_id=" + order.getCustomerID() + ", employee_id=" + order.getEmployeeID() + ", total=" + order.getTotal()+ " WHERE order_id=" + order.getOrderID();
            int row = st.executeUpdate(sql);
            System.out.println("Update order successfully: " + sql);
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
            String sql = "DELETE FROM Orders WHERE order_id=" + ID;
            int row = st.executeUpdate(sql);
            System.out.println("Delete order successfully: " + sql);
            System.out.println(row + " rows deleted");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> selectAll() {
        ArrayList<Order> result = new ArrayList<Order>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Orders";
            ResultSet rs = st.executeQuery(sql);
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
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Orders WHERE order_id = " + ID;
            ResultSet rs = st.executeQuery(sql);
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

    public static ArrayList<Order> selectByCondition(String condition) {
        ArrayList<Order> result = new ArrayList<Order>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Orders WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);
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
}
