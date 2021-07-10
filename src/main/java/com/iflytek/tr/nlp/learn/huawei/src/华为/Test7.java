package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        srcStr = srcStr.substring(1, srcStr.length() - 1);
        int sum = sc.nextInt();
        String[] arr = srcStr.split(",");
        for (int i=1; i< arr.length; i++){ // 取的个数
            for (int j=0; j< arr.length +1 -i; j++){ // 循环的次数
                for (int n= 0; n< arr.length; n++){

                }
            }
        }
    }
}
