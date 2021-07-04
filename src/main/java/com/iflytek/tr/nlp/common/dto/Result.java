package com.iflytek.tr.nlp.common.dto;

import com.alibaba.fastjson.JSONObject;

import com.iflytek.tr.nlp.common.contants.ErrorCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Result<T> {

    private String errorMessage = ErrorCode.SUCCESS.getMsg();
    private int errorCode = ErrorCode.SUCCESS.getCode();
    private boolean success = ErrorCode.SUCCESS.isSuccess();
    private Object data;

    public static <T> Result<T> fail(ErrorCode code) {
        return fail(code.getCode(), code.getMsg(), code.isSuccess());
    }

    public static <T> Result<T> fail(int code, String message, boolean success) {
        Result<T> result = new Result<T>();
        result.errorCode = code;
        result.errorMessage = message;
        result.success = success;
        result.data = new JSONObject();
//        log.info(message);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        return fail(ErrorCode.UNKNOWNFAIL.getCode(), message, false);
    }

    public static <T> Result<T> success(T value) {
        Result<T> result = new Result<T>();
//        if (value == null) {
//            result.setData(new JSONObject());
//        } else {
//            result.setData(value);
//        }
        result.errorCode = ErrorCode.SUCCESS.getCode();
        result.success = ErrorCode.SUCCESS.isSuccess();
        return result;
    }

    

}
