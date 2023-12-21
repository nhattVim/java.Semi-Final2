package dao;

import common.DatabaseConnector;
import entities.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {

    public static void insert(Customer customer) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "INSERT INTO Customer VALUES (" + customer.getCustomerID() + ", '" + customer.getCustomerName() + "')";
            int row = st.executeUpdate(sql);
            System.out.println("Insert customer successfully: " + sql);
            System.out.println(row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Customer customer) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "UPDATE Customer SET customer_name = '" + customer.getCustomerName() + "' WHERE customer_id = " + customer.getCustomerID();
            int row = st.executeUpdate(sql);
            System.out.println("Update customer successfully: " + sql);
            System.out.println(row + " rows update");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "DELETE FROM Customer WHERE customer_id = " + ID;
            int row = st.executeUpdate(sql);
            System.out.println("Delete customer successfully: " + sql);
            System.out.println(row + " rows delete");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Customer> selectAll() {
        ArrayList<Customer> result = new ArrayList<Customer>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Customer";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int customerID = rs.getInt("customer_id");
                String customerName = rs.getString("customer_name");

                Customer customer = new Customer(customerID, customerName);
                result.add(customer);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Customer selectById(int ID) {
        Customer result = null;
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Customer WHERE customer_id = " + ID;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int customerID = rs.getInt("customer_id");
                String customerName = rs.getString("customer_name");
                result = new Customer(customerID, customerName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Customer> selectByCondition(String condition) {
        ArrayList result = new ArrayList<Customer>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Customer WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int customerID = rs.getInt("customer_id");
                String customerName = rs.getString("customer_name");

                Customer customer = new Customer(customerID, customerName);
                result.add(customer);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
