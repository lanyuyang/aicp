package com.iflytek.tr.nlp.learn.enumService;

import javax.lang.model.element.NestingKind;

public enum AlarmEnum {
    R_LOS(1,"r_los"),
    R_LOS_NA(3001,"r_los_na"),
    MUT_LOS(31,"mut_los");
    private int code;
    private String value;
    AlarmEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public static AlarmEnum getAlarm(int code){
        for (AlarmEnum alarmEnum: AlarmEnum.values()){
            if (alarmEnum.code == code){
                return alarmEnum;
            }
        }
        return null;
    }
    public static AlarmEnum getAlarm(String value){
        for (AlarmEnum alarmEnum:AlarmEnum.values()){
            if (alarmEnum.value.equals(value)){
                return alarmEnum;
            }
        }
        return null;
    }
    public String getValue(){
        return value;
    }

    public int getCode(){
        return code;
    }
}
