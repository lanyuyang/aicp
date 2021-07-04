package com.iflytek.tr.nlp.common;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 10:14 2019/4/12
 */
public class ResponseData {
    private Object data;
    private int errorCode;
    private boolean success;
    private String errorMessage;

    public ResponseData(){
        this.success = true;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(boolean success, int errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
