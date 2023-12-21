package entities;

public class Product {
    private int productID;
    private String productName;
    private double listPrice;

    public Product() {}

    public Product(int productID) {
        this.productID = productID;
    }

    public Product(int productID, String productName, double listPrice) {
        this.productID = productID;
        this.productName = productName;
        this.listPrice = listPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", listPrice=" + listPrice +
                '}';
    }
}
