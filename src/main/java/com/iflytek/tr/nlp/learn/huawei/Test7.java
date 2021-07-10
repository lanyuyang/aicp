package com.iflytek.tr.nlp.learn.huawei;

import java.util.Scanner;

/**
 * Created by yylan on 2021/2/22.
 * 寻找最长回文子串
 * 回文字符串，指的是形式如同"abcba"或是"abccba“形式的字符串。

 那么如何在一串给定的字符串中寻找其中最长的回文子串呢？

 可以用延伸的思想来寻找，即先找最短的字符串如"a"、"bb"等，在这些字符串基础上进行延伸扩展，若是找到的符合要求的子串长度大于已找到的回文子串的最大长度，则取而代之，同时记录该子串的第一个字符的下标。

 通过这种思想将字符串遍历执行即可找到最大回文子串。
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String res = longestPalindrome(src);
        System.out.println(res);
    }

    private static int start,maxLength;
    public static String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        for(int i=0;i<s.length()-1;i++){
            extendPali(s,i,i);
            extendPali(s,i,i+1);
        }
        return s.substring(start,start+maxLength);
    }
    public static void extendPali(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxLength<j-i-1){
            start=i+1;
            maxLength=j-i-1;
        }
    }

}
