package com.iflytek.tr.nlp.common.exception;

import com.iflytek.tr.nlp.common.contants.ErrorCode;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 9:49 2019/4/12
 */
public class BaseException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 8944431786441920015L;
    protected int errorCode;
    protected String message;
    protected boolean success;
    protected Throwable e;

    public BaseException(int errorCode,String message, boolean success){
        super(message);
        this.errorCode=errorCode;
        this.message=message;
        this.success = success;
    }

    public BaseException(int errorCode,String message,Throwable e){
        this.errorCode=errorCode;
        this.message=message;
        this.e=e;
    }

    public BaseException(ErrorCode errorCode){
        this.errorCode=errorCode.getCode();
        this.message=errorCode.getMsg();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getE() {
        return e;
    }

    public void setE(Throwable e) {
        this.e = e;
    }
}
