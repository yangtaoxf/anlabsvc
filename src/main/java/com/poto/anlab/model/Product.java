package com.poto.anlab.model;

import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private String productDesc;
    private String imageOriginName;
    private String imageNewName;
    private String imagePath;
    private int manufacturerId;
    private String manufacturerCnName;
    private String manufacturerEnName;
    private int categoryId;
    private String categoryCnName;
    private String categoryEnName;
    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getImageOriginName() {
        return imageOriginName;
    }

    public void setImageOriginName(String imageOriginName) {
        this.imageOriginName = imageOriginName;
    }

    public String getImageNewName() {
        return imageNewName;
    }

    public void setImageNewName(String imageNewName) {
        this.imageNewName = imageNewName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerCnName() {
        return manufacturerCnName;
    }

    public void setManufacturerCnName(String manufacturerCnName) {
        this.manufacturerCnName = manufacturerCnName;
    }

    public String getManufacturerEnName() {
        return manufacturerEnName;
    }

    public void setManufacturerEnName(String manufacturerEnName) {
        this.manufacturerEnName = manufacturerEnName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCnName() {
        return categoryCnName;
    }

    public void setCategoryCnName(String categoryCnName) {
        this.categoryCnName = categoryCnName;
    }

    public String getCategoryEnName() {
        return categoryEnName;
    }

    public void setCategoryEnName(String categoryEnName) {
        this.categoryEnName = categoryEnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
