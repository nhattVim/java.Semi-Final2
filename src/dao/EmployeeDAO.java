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
            Statement st = c.createStatement();
            String sql = "INSERT INTO Employee VALUES (" +employee.getEmployeeID()+ ", '" +employee.getEmployeeName()+ "', '" +employee.getSalary()+ "', " +employee.getSpvrID()+")";
            int row = st.executeUpdate(sql);
            System.out.println("Insert employee successfully: " + sql);
            System.out.println(row + " row insert");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Employee employee) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "UPDATE Employee SET employee_name = '" +employee.getEmployeeName()+ "' , salary = " +employee.getSalary()+ ", supervisor_id = " +employee.getSpvrID()+ " WHERE employee_id = " + employee.getEmployeeID();
            int row = st.executeUpdate(sql);
            System.out.println("Update employee successfully: " + sql);
            System.out.println(row + " row update");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int ID) {
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "DELETE FROM Employee WHERE employee_id = " + ID;
            int row = st.executeUpdate(sql);
            System.out.println("Delete employee successfully: " + sql);
            System.out.println(row + " row delete");
            DatabaseConnector.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> selectAll() {
        ArrayList<Employee> result = new ArrayList<Employee>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Employee";
            ResultSet rs = st.executeQuery(sql);
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
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Employee WHERE employee_id = " + ID;
            ResultSet rs = st.executeQuery(sql);
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

    public static ArrayList<Employee> selectByCondition(String condition) {
        ArrayList result = new ArrayList<Employee>();
        try {
            Connection c = DatabaseConnector.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM Employee WHERE " + condition;
            ResultSet rs = st.executeQuery(sql);
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
}
