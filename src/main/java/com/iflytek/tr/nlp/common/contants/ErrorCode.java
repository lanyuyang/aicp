package com.iflytek.tr.nlp.common.contants;

/**
 * @ Author     ：yylan
 * @ Date       ：Created in 9:47 2019/4/12
 */
public enum ErrorCode {
    /**
     * 成功
     */
    SUCCESS(0, "success", true),
    /**
     * 失败
     */
    UNKNOWNFAIL(1, "fail", false),
    /**
     * 服务器异常
     */
    EXCEPTION(1001, "服务器异常", false),

    /**
     * 状态已存在
     */
    EXISTED(1002, "状态已存在", false),
    /**
     * 状态不存在
     */
    NOT_EXISTED(1003, "状态不存在", false),

    PARAM_ERROR(1101, "参数错误", false);



    private int code;
    private String msg;
    private boolean success;

    private ErrorCode(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }
}
