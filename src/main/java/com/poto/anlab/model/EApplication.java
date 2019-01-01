package com.poto.anlab.model;

public class EApplication {
    private int id;
    private String cnName;
    private String enName;

    public EApplication() {
    }

    public EApplication(int id, String cnName, String enName) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }
}
