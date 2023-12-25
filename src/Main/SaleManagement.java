package Main;

import dao.*;
import entities.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class SaleManagement {

    public static void main(String[] args) {
        Random random = new Random();

        /*
        * CustomerDAO
        */

        /* insert */
        for (int i = 1; i <= 100; i++) {
            Customer customer = new Customer(i, "insert " + i);
            CustomerDAO.insert(customer);
        }

        /* update */
//        for (int i = 1; i <= 100; i++) {
//            Customer customer = new Customer(i,"update " + i);
//            CustomerDAO.update(customer);
//        }

        /* delete */
//        for (int i = 0; i <= 100; i++) {
//            CustomerDAO.delete(i);
//        }
//
        /* select all */
//        ArrayList<Customer> list = CustomerDAO.selectAll();
//        for (Customer customer : list) {
//            System.out.println(customer.toString());
//        }

        /* select by id */
//        Customer customer = CustomerDAO.selectById(1);
//        System.out.println(customer.toString());

        /*
        * EmployeeDao
        */

        /* insert */
        for (int i = 1; i <= 100; i++) {
            Employee employee = new Employee(i, "insert " + i, 50000 + i, i);
            EmployeeDAO.insert(employee);
        }

        /* update */
//        for (int i = 1; i <= 100; i++) {
//            Employee employee = new Employee(i, "update " + i, 20000 + i, i);
//            EmployeeDAO.update(employee);
//        }

        /* delete */
//        for (int i = 1; i <= 100; i++) {
//            EmployeeDAO.delete(i);
//        }

        /* select all */
//        ArrayList<Employee> list = EmployeeDAO.selectAll();
//        for (Employee employee : list) {
//            System.out.println(employee.toString());
//        }

        /* select by id */
//        Employee employee = EmployeeDAO.selectById(18);
//        System.out.println(employee.toString());

        /*
        *  LineItemDAO
        */

        /* insert */
        for (int i = 1; i < 100; i++) {
            int order_id = random.nextInt(100) + 1;
            int product_id = random.nextInt(100) + 1;
            int quantity = random.nextInt(100) + 1;

            LineItem lineItem = new LineItem(order_id, product_id, quantity, 900000 + i);
            LineItemDAO.insert(lineItem);
        }

        /* update */
//        LineItem lineItem = new LineItem(51, 32, 9000, 200000);
//        LineItemDAO.update(lineItem);

        /* delete */
//        LineItemDAO.delete(51, 32);

        /* select all */
//        ArrayList<LineItem> list = LineItemDAO.selectAll();
//        for (LineItem lineItem: list) {
//            System.out.println(lineItem.toString());
//        }

        /* select by id */
//        LineItem lineItem = LineItemDAO.selectById(48, 46);
//        System.out.println(lineItem.toString());

        /*
        *  OrderDAO
        */

        /* insert */
        for (int i = 1; i <= 100; i++) {
            int year = 2023;
            int month = random.nextInt(12) + 1; // Month is between 1 and 12
            int day = random.nextInt(28) + 1; // Day is between 1 and 28 for simplicity
            int total = random.nextInt(500) + 1;
            Date randomDate = Date.valueOf(year + "-" + month + "-" + day);

            // Create a random Order
            Order order = new Order(i, randomDate, random.nextInt(100), random.nextInt(100), total);
            OrderDAO.insert(order);
        }

        /* update */
//        for (int i = 1; i <= 100; i++) {
//            int year = 2023;
//            int month = random.nextInt(12) + 1; // Month is between 1 and 12
//            int day = random.nextInt(28) + 1; // Day is between 1 and 28 for simplicity
//            Date randomDate = Date.valueOf(year + "-" + month + "-" + day);
//            int total = random.nextInt(500) + 1;
//
//            // Create a random Order
//            Order order = new Order(i, randomDate, random.nextInt(100), random.nextInt(100), total);
//            OrderDAO.update(order);
//        }

        /* delete */
//        for (int i = 1; i <= 100; i++) {
//            OrderDAO.delete(i);
//        }

        /* select all */
//        ArrayList<Order> list = OrderDAO.selectAll();
//        for (Order order : list) {
//            System.out.println(order.toString());
//        }

        /* select by id */
//        Order order = OrderDAO.selectById(5);
//        System.out.println(order.toString());

        /*
        *  ProductDAO
        */

        /* insert */
        for (int i = 1; i <= 100; i++) {
            Product product = new Product(i, "insert " + i, 500 + i);
            ProductDAO.insert(product);
        }

        /* update */
//        for (int i = 1; i <= 100; i++) {
//            Product product = new Product(i, "update " + i, 204 + i);
//            ProductDAO.update(product);
//        }

        /* delete */
//        for (int i = 1; i <= 100; i++) {
//            ProductDAO.delete(i);
//        }

        /* select all */
//        ArrayList<Product> list = ProductDAO.selectAll();
//        for (Product product : list) {
//            System.out.println(product.toString());
//        }

        /* select by id */
//        Product product = ProductDAO.selectById(5);
//        System.out.println(product.toString());
    }
}
