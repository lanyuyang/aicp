package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 计算某字母出现次数
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        if (!isLetterDigit(srcStr)){
            System.out.println("no");
        }
        String decStr = sc.next();
// 8 8 8  8A i i OOI              IIIaa
        int count = 0;
        for (int i=0; i<srcStr.length(); i++){
            String temp = srcStr.substring(i, i+1);
            if (temp.equalsIgnoreCase(decStr)){
                count ++;
            }
        }
        System.out.println(count);
    }
    public static boolean isLetterDigit(String str) {
        String regex = "^[a-z0-9A-Z ]+$";
        return str.matches(regex);
    }
}
