package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.next();
        List<String> list = Arrays.asList(srcStr.split(";"));
        int x = 0;
        int y = 0;
        for (String str : list){
            if (isYes(str)){
                String fistC = str.substring(0, 1);
                String aftC = str.substring(1,str.length());
                int aftNum = Integer.valueOf(aftC);
                if ("A".equals(fistC))
                    x = x-aftNum;
                if ("D".equals(fistC))
                    x = x+aftNum;
                if ("W".equals(fistC))
                    y = y+aftNum;
                if ("S".equals(fistC))
                    y = y-aftNum;

            }
        }
        System.out.println(x +","+ y);
    }
    public static boolean isYes(String str){
        if (null == str || "".equals(str) || str.length() == 1)
            return false;
        String fistC = str.substring(0, 1);
        String aftC = str.substring(1,str.length());
        if (!"ASWD".contains(fistC))
            return false;
        Pattern pattern =Pattern.compile("[0-9]*");
        if (!pattern.matcher(aftC).matches())
            return false;
        return true;
    }
    /**
     * 字符统计
     */
    public static void test2(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<String>();
        for (int i=0;i< str.length(); i++){
            String temp = str.substring(i, i+1);
            if (!list.contains(temp)){
                list.add(temp);
            }
        }
        System.out.println(list.size());
    }
}
