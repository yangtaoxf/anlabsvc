package com.poto.anlab.model;

public class User {
    private int userId;
    private String user_name;


    public User(){

    }

    public User(int userId, String user_name) {
        this.userId = userId;
        this.user_name = user_name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
