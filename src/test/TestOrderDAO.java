package test;

import dao.OrderDAO;
import entities.Order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class TestOrderDAO {

    public static void main(String[] args) {
        Random random = new Random();

        /* Test insert */
//        for (int i = 1; i <= 100; i++) {
//            int year = 2023;
//            int month = random.nextInt(12) + 1; // Month is between 1 and 12
//            int day = random.nextInt(28) + 1; // Day is between 1 and 28 for simplicity
//            int total = random.nextInt(500) + 1;
//            Date randomDate = Date.valueOf(year + "-" + month + "-" + day);
//
//            // Create a random Order
//            Order order = new Order(i, randomDate, random.nextInt(100), random.nextInt(100), total);
//            OrderDAO.insert(order);
//        }

        /* Test update */
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

        /* Test delete */
//        for (int i = 1; i <= 100; i++) {
//            OrderDAO.delete(i);
//        }

        /* Test select all */
//        ArrayList<Order> list = OrderDAO.selectAll();
//        for (Order order : list) {
//            System.out.println(order.toString());
//        }

        /* Test select by id */
//        Order order = OrderDAO.selectById(5);
//        System.out.println(order.toString());

        /* Test select by condition */
        ArrayList<Order> list = OrderDAO.selectByCondition("order_id < 10");
        for (Order order : list) {
            System.out.println(order.toString());
        }
    }
}
