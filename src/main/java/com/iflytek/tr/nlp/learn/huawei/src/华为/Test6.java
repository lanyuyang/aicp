package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 特殊计算
 *
 * 特殊符号代替普通的计算方式比如x#y = 2*x+y，x$y = x+3y，#优先级高于$
 *
 * 比如输入5#2$6 输出结果就是30，因为先算5#2 = 12，再算12$6=30
 * 5#2$6 = 30
 * 5$2#6 = 35
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        while (srcStr.contains("#")|| srcStr.contains("$")){
            String[] arr = srcStr.split("#|\\$");
            String ss = "";
            int index = 0 ;
            index = srcStr.indexOf('#');
            ss = "#";
            if (index == -1){
                index = srcStr.indexOf('$');
                ss = "$";
            }
            String befStr = srcStr.substring(0, index);
            int index1 = count(befStr);
            int x= Integer.parseInt(arr[index1]);
            int y= Integer.parseInt(arr[index1+1]);
            String r1 = arr[index1] + ss + arr[index1+1];
            String res = test1(x, y, ss);
            srcStr = srcStr.replace(r1, res);
        }
        System.out.println(srcStr);
    }
    public static String test1(int x, int y, String ss){

        if (ss.contains("#")){
            int res = 2*x + y;
            return String.valueOf(res);
        }
        if (ss.contains("$")){
            int res = x + 3*y;
            return String.valueOf(res);
        }
        return "";
    }

    public static int count(String srcStr){
        int count = 0;
        char[] ch = srcStr.toCharArray();
        for (char c : ch){
            if (c == '$'){
                count ++;
            }
        }
        return count;
    }
}
