package com.poto.anlab.model;

public class ProductImg {
    private int id;
    private int productId;
    private int imgId;
    private String imgPath;

    public ProductImg() {
    }

    public ProductImg(int id, int productId, int imgId, String imgPath) {
        this.id = id;
        this.productId = productId;
        this.imgId = imgId;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
