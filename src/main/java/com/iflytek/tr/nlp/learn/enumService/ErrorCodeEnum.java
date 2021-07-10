package com.iflytek.tr.nlp.learn.enumService;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public enum ErrorCodeEnum {
    SUCCESS(new int[]{0,00,000},"成功",true),
    FAIL(new int[]{1,11,111},"失败",false),
    EXCEPTION(new int[]{2,22,222},"异常",false),
    UNKNOWN(new int[]{},"未知",false);
    private int[] codeArr;
    private String msg;
    private boolean isSuccess;
    ErrorCodeEnum(int[] codeArr, String msg, boolean isSuccess){
        this.codeArr = codeArr;
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public int[] getCodeArr() {
        return Arrays.copyOf(codeArr, codeArr.length);
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCodeEnum from(int code){
        for (ErrorCodeEnum codeEnum:ErrorCodeEnum.values()){
            int[] codeArr = codeEnum.getCodeArr();
            for (int i=0; i< codeArr.length; i++){
                if (codeArr[i] == code){
                    return codeEnum;
                }
            }
        }
        return UNKNOWN;
    }
}
