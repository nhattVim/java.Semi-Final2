package dao;

import common.DatabaseConnector;
import entities.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    public static void insert(Customer customer) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("INSERT INTO Customer VALUES (?, ?)");

            pst.setInt(1, customer.getCustomerID());
            pst.setString(2, customer.getCustomerName());

            int row = pst.executeUpdate();
            System.out.println("Insert customer successfully: " + row + " rows inserted");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Customer customer) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("UPDATE Customer SET customer_name = ? WHERE customer_id = ?");
            pst.setString(1, customer.getCustomerName());
            pst.setInt(2, customer.getCustomerID());
            int row = pst.executeUpdate();
            System.out.println("Update customer successfully: " + row + " rows update");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("DELETE FROM Customer WHERE customer_id = ? ");
            pst.setInt(1, ID);
            int row = pst.executeUpdate();
            System.out.println("Delete customer successfully: " + row + " rows delete");
            DatabaseConnector.closeConnection(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Customer> selectAll() {
        ArrayList<Customer> result = new ArrayList<Customer>();
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("SELECT * FROM Customer");
            ResultSet rs = pst.executeQuery();
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
            PreparedStatement pst = c.prepareStatement("SELECT * FROM Customer WHERE customer_id = ?");
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
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
}
