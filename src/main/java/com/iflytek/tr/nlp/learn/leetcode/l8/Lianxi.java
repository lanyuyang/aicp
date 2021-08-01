package com.iflytek.tr.nlp.learn.leetcode.l8;

public class Lianxi {
    public static void main(String[] args) {
        String  s = " 2323dd ";
        System.out.println(myAio(s));
    }
    private static int myAio(String s){
        char[] chars = s.toCharArray();
        // 去除前导空格(移动左边法去除)
        int index = 0;
        int legth = chars.length;
        while (index < legth && chars[index] == ' '){
            index++;
        }
        if (index == legth){
            return 0;
        }
        // 检查正负号
        int sign = 1;
        if (chars[index] == '+'){
            index ++;
        }else if (chars[index] == '-'){
            index++;
            sign = -1;
        }
        int res = 0;
        for (; index< legth; index++){
            char currChar = chars[index];
            if (chars[index] < '0' || chars[index] > '9'){
                break;
            }
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (currChar - '0') > Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && (currChar - '0') > -(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (currChar - '0') * sign;
        }
        return res;
    }
}
