package test;

import dao.EmployeeDAO;
import dao.LineItemDAO;
import entities.Employee;
import entities.LineItem;

import java.util.ArrayList;
import java.util.Random;

public class TestLineItemDAO {

    public static void main(String[] args) {
        Random random = new Random();

        /* Test insert */
//        for (int i = 1; i < 100; i++) {
//            int order_id = random.nextInt(100) + 1;
//            int product_id = random.nextInt(100) + 1;
//            int quantity = random.nextInt(100) + 1;
//
//            LineItem lineItem = new LineItem(order_id, product_id, quantity, 900000 + i);
//            LineItemDAO.insert(lineItem);
//        }

        /* Test update */
//        LineItem lineItem = new LineItem(51, 32, 9000, 200000);
//        LineItemDAO.update(lineItem);

        /* Test delete */
//        LineItemDAO.delete(51, 32);

        /* Test select all */
//        ArrayList<LineItem> list = LineItemDAO.selectAll();
//        for (LineItem lineItem: list) {
//            System.out.println(lineItem.toString());
//        }

        /* Test select by id */
//        LineItem lineItem = LineItemDAO.selectById(48, 46);
//        System.out.println(lineItem.toString());
    }
}
