package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串匹配
 *
 * 给出一个字符串，给出一个正则白表达式子串，找出可以找到子串的第一个位置。
 *
 * 例如:字符串asdfas，子串是d[sf]，（[]表示里边任意一个元素），输出为3，因为ds或df去匹配字符串，找到df输出位置为3。
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        String subStr = sc.nextLine();
        List<String> resList = dealSubStr(subStr);

        int index = srcStr.length();
        for (String str : resList){
            int dd = srcStr.indexOf(str);
            if (dd < index && dd != -1)
                index = dd;
        }
        System.out.println(index+1);
    }
    public static List<String> dealSubStr(String subStr){
        List<String> resList = new ArrayList<String>();
        int start = subStr.indexOf('[');
        int end = subStr.indexOf(']');
        String befStr = subStr.substring(0, start);
        String aftStr = subStr.substring(end+1, subStr.length());
        String midStr = subStr.substring(start+1, end);
        for (int i=0; i< midStr.length(); i++){
            char c = midStr.charAt(i);
            String cc = String.valueOf(c);
            String res = befStr+cc+aftStr;
            resList.add(res);
        }
        return resList;
    }

}
