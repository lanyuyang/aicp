package com.iflytek.tr.nlp.learn.huawei.kaoshi;

import java.util.Scanner;

/**
 * Created by yylan on 2021/2/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 300;
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(",|，");
            int pice = Integer.valueOf(arr[0]);
            int day0= Integer.valueOf(arr[1]); // 预定天数
            int day1= Integer.valueOf(arr[2]); // 实际天数

            int huafei = 0;
            if (pice >= 100 && money >=pice){
                if (day1 <= 15){
                    huafei = day1 * 5;
                }else {
//                    huafei = day1 * 3;
                    huafei = 15 * 5 + (day1 -15)*3;
                }
                int yqDay = day1 - day0; // 逾期天数
                if (yqDay > 0){
                    huafei = huafei + yqDay;
                }
            }else if (pice >= 50 && pice <100 && money >=pice){
                if (day1 <= 15){
                    huafei = day1 * 3;
                }else {
//                    huafei = day1 * 2;
                    huafei = 15 * 3 + (day1 -15)*2;
                }
                int yqDay = day1 - day0; // 逾期天数
                if (yqDay > 0){
                    huafei = huafei + yqDay;
                }
            }else if (pice <50 && money >=pice){
                huafei = day1 * 1;
                int yqDay = day1 - day0; // 逾期天数
                if (yqDay > 0){
                    huafei = huafei + yqDay;
                }
            }
            money = money - huafei;
            System.out.println(money);
        }
    }
}
