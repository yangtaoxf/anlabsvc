package com.poto.anlab.model;

public class ProductImageVO {
    private String imageOriginName;
    private String imageNewName;
    private String imagePath;

    public ProductImageVO() {
    }

    public ProductImageVO(String imageOriginName, String imageNewName, String imagePath) {
        this.imageOriginName = imageOriginName;
        this.imageNewName = imageNewName;
        this.imagePath = imagePath;
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
}
