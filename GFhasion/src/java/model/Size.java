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
public class Size {
    
    private String pid;
    private String name;
    private int size_quantity;

    public Size() {
    }

    public Size(String pid, String name, int size_quantity) {
        this.pid = pid;
        this.name = name;
        this.size_quantity = size_quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize_quantity() {
        return size_quantity;
    }

    public void setSize_quantity(int size_quantity) {
        this.size_quantity = size_quantity;
    }

    @Override
    public String toString() {
        return "Size{" + "pid=" + pid + ", name=" + name + ", size_quantity=" + size_quantity + '}';
    }
    
    
}
