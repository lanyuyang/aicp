package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 重复数字
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = Integer.toString(num);
        if (str.endsWith("0"))
            System.out.println("no");
        List<String> list = new ArrayList<String>();
        for (int i=0; i< str.length(); i++){
            String temp = str.substring(str.length()-i-1, str.length()-i);
            if (!list.contains(temp)){
                list.add(temp);
            }
        }
        for (String s : list){
            System.out.print(s);
        }
    }
}
