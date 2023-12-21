package test;

import dao.OrderDAO;
import dao.ProductDAO;
import entities.Order;
import entities.Product;

import java.util.ArrayList;

public class TestProductDAO {

    public static void main(String[] args) {
        /* Test insert */
//        for (int i = 1; i <= 100; i++) {
//            Product product = new Product(i, "Test insert " + i, 500 + i);
//            ProductDAO.insert(product);
//        }

        /* Test update */
//        for (int i = 1; i <= 100; i++) {
//            Product product = new Product(i, "Test update " + i, 204 + i);
//            ProductDAO.update(product);
//        }

        /* Test delete */
//        for (int i = 1; i < 100; i++) {
//            ProductDAO.delete(i);
//        }

        /* Test select all */
//        ArrayList<Product> list = ProductDAO.selectAll();
//        for (Product product : list) {
//            System.out.println(product.toString());
//        }

        /* Test select by id */
//        Order order = OrderDAO.selectById(5);
//        System.out.println(order.toString());

        /* Test select by condition */
        ArrayList<Product> list = ProductDAO.selectByCondition("product_id < 10");
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
