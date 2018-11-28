package com.anlab.model;

public class AnlabUser {
    private int userId;
    private String userName;

    public AnlabUser() {
    }

    public AnlabUser(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
