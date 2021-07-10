package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 字符串分割
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String srcStr = sc.next();
            int num = srcStr.length();
            int s = num % 8;
            if (s != 0){
                for (int i=0; i< 8-s; i++){
                    srcStr = srcStr + "0";
                }
            }

            for (int i=0; i< srcStr.length(); i++){
                System.out.println(srcStr.substring(i, i+8));
                i = i+7;
            }
        }
    }
}
