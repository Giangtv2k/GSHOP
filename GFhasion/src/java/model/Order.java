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
public class Order {

    private int id;
    private Date date;
    private String usernameCustomer;
    private double totalmoney;

    public Order() {
    }

    public Order(int id, Date date, String usernameCustomer, double totalmoney) {
        this.id = id;
        this.date = date;
        this.usernameCustomer = usernameCustomer;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsernameCustomer() {
        return usernameCustomer;
    }

    public void setUsernameCustomer(String usernameCustomer) {
        this.usernameCustomer = usernameCustomer;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", usernameCustomer=" + usernameCustomer + ", totalmoney=" + totalmoney + '}';
    }
    
    
}
