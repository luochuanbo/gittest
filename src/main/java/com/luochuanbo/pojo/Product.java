package com.luochuanbo.pojo;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Date:2019/3/24
 * User: luobin
 * Desc: 定义域相关的实体
 */
public class Product {

    @Field("pid")
    private String pid;
    @Field
    private String name;
    @Field("catalog_name")
    private String catalogName;
    @Field
    private double price;
    @Field
    private String description;
    @Field
    private String picture;

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

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", catalogName='" + catalogName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
