/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Minh Thanh
 */
public class OrderDetail {

    private int oid;
    private String pid;
    private String size;
    private int quantity;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int oid, String pid, String size, int quantity, double price) {
        this.oid = oid;
        this.pid = pid;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "oid=" + oid + ", pid=" + pid + ", size=" + size + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
}
