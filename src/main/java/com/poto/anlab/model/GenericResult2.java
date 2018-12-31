package com.poto.anlab.model;

public class GenericResult2<T> {
    private boolean success;
    private String errorSummary;
    private T data;

    public GenericResult2(boolean success, String errorSummary,T data) {
        this.success = success;
        this.errorSummary = errorSummary;
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public GenericResult2() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorSummary() {
        return errorSummary;
    }

    public void setErrorSummary(String errorSummary) {
        this.errorSummary = errorSummary;
    }
}
