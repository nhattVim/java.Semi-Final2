package entities;

import java.sql.Date;

public class Order {
    private int orderID;
    private Date oderDate;
    private int customerID;
    private int employeeID;
    private double total;

    public Order() {}

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public Order(int orderID, Date oderDate, int customerID, int employeeID, double total) {
        this.orderID = orderID;
        this.oderDate = oderDate;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", oderDate=" + oderDate +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", total=" + total +
                '}';
    }
}
