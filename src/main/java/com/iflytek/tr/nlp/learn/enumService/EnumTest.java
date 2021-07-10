package com.iflytek.tr.nlp.learn.enumService;

import com.alibaba.fastjson.JSON;

public class EnumTest {
    public static void main(String[] args) {
        // 获取所有枚举数据
        System.out.println(JSON.toJSON(AlarmEnum.values()));
        // 根据枚举code 获取枚举类
        System.out.println(AlarmEnum.getAlarm(3001));
        System.out.println(AlarmEnum.getAlarm(3001).getValue());
        // 根据枚举value 获取枚举类
        System.out.println(AlarmEnum.getAlarm("mut_los"));
        System.out.println(AlarmEnum.getAlarm("mut_los").getCode());


        // 根据code获取ErrorCodeEnum
        System.out.println(ErrorCodeEnum.from(222).getMsg());
        System.out.println(ErrorCodeEnum.from(222).toString());
    }
}
