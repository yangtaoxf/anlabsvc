package com.poto.anlab.model;

import java.util.List;
import java.util.Objects;

public class ProductVO {
    private int productId;
    private String productName;
    private String productDesc;
    private int manufacturerId;
    private String manufacturerCnName;
    private String manufacturerEnName;
    private int categoryId;
    private String categoryCnName;
    private String categoryEnName;
    private List<ProductImageVO> productImageVOList;
    public ProductVO() {
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

    public List<ProductImageVO> getProductImageVOList() {
        return productImageVOList;
    }

    public void setProductImageVOList(List<ProductImageVO> productImageVOList) {
        this.productImageVOList = productImageVOList;
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
        ProductVO product = (ProductVO) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
