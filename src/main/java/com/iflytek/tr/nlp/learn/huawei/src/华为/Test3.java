package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        String[] strArr = srcStr.split(" ");
        System.out.println(strArr[strArr.length-1].length());
    }
}
