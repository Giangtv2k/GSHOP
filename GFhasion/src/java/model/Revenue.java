/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Minh Thanh
 */
public class Revenue {

    private String pid;
    private String productName;
    private String image;
    private double price;
    private String size;
    private int quantity;
    private int oid; // order id
    private String customer; //username account
    private Date orderDate;
    private double totalMoney;

    public Revenue() {
    }

    public Revenue(String pid, String productName, String image, double price, String size, int quantity, int oid, String customer, Date orderDate,double totalMoney) {
        this.pid = pid;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.oid = oid;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalMoney = totalMoney;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    

    @Override
    public String toString() {
        return "Revenue{" + "pid=" + pid + ", productName=" + productName + ", image=" + image + ", price=" + price + ", size=" + size + ", quantity=" + quantity + ", oid=" + oid + ", customer=" + customer + ", orderDate=" + orderDate + '}';
    }
    
    

}
