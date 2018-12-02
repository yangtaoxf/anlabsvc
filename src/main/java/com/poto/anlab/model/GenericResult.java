package com.poto.anlab.model;

public class GenericResult {
    private boolean success;
    private String errorSummary;

    public GenericResult(boolean success, String errorSummary) {
        this.success = success;
        this.errorSummary = errorSummary;
    }

    public static GenericResult getSuccess(){
        return new GenericResult(true,"");
    }

    public static GenericResult getFailed(String error){
        return new GenericResult(false,error);
    }

    public GenericResult() {
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
