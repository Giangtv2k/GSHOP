/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Minh Thanh
 */
public class Product {

    private String id;
    private String name;
    private String cid;
    private String image;
    private double price;
    private String description;
    private Date dateCreated;
    private List<Size> listSize;

    public Product() {
    }

    public Product(String id, String name, String cid, String image, double price, String description, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.image = image;
        this.price = price;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    public Product(String id, String name, String cid, String image, double price, String description, Date dateCreated, List<Size> listSize) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.image = image;
        this.price = price;
        this.description = description;
        this.dateCreated = dateCreated;
        this.listSize = listSize;
    }
    
    

    public List<Size> getListSize() {
        return listSize;
    }

    public void setListSize(List<Size> listSize) {
        this.listSize = listSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
//        String sPrice = String.format("%,.0f", price);
//        price = Double.parseDouble(sPrice);
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", cid=" + cid + ", image=" + image + ", price=" + price + ", description=" + description + ", dateCreated=" + dateCreated + '}';
    }
    
   

}
