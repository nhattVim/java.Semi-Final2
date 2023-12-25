package dao;

import common.DatabaseConnector;
import entities.Customer;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {

    public static void insert(Employee employee) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?)");
            pst.setInt(1, employee.getEmployeeID());
            pst.setString(2, employee.getEmployeeName());
            pst.setDouble(3, employee.getSalary());
            pst.setInt(4, employee.getSpvrID());
            int row = pst.executeUpdate();
            System.out.println("Insert employee successfully: " + row + " rows insert");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Employee employee) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement pst = c.prepareStatement("UPDATE Employee SET employee_name = ?, salary = ?, supervisor_id = ? WHERE employee_id = ?");
            pst.setString(1, employee.getEmployeeName());
            pst.setDouble(2, employee.getSalary());
            pst.setInt(3, employee.getSpvrID());
            pst.setInt(4, employee.getEmployeeID());
            int row = pst.executeUpdate();
            System.out.println("Update employee successfully: " + row + " rows update");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Employee WHERE employee_id = ?");
            ps.setInt(1, ID);
            int row = ps.executeUpdate();
            System.out.println("Delete employee successfully: " + row + " row delete");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> selectAll() {
        ArrayList<Employee> result = new ArrayList<Employee>();
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int employee_id  = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                double salary = rs.getDouble("salary");
                int spvr_id = rs.getInt("supervisor_id");

                Employee employee = new Employee(employee_id, employee_name, salary, spvr_id);
                result.add(employee);
            }
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Employee selectById(int ID) {
        Employee result = null;
        try {
            Connection c = DatabaseConnector.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Employee WHERE employee_id = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int employee_id  = rs.getInt("employee_id");
                String employee_name = rs.getString("employee_name");
                double salary = rs.getDouble("salary");
                int spvr_id = rs.getInt("supervisor_id");
                result = new Employee(employee_id, employee_name, salary, spvr_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
