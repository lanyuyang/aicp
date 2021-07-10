package com.iflytek.tr.nlp.learn.huawei;

import java.util.Scanner;

/**
 * Created by yylan on 2021/2/20.
 */
public class kaopuNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int count = num;
            for (int i = 1; i<= num; i++){
                if (String.valueOf(i).contains("7")){
                    count --;
                }
            }
            System.out.println(count);
        }
    }
}
