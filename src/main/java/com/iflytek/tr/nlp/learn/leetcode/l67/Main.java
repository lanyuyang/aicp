package com.iflytek.tr.nlp.learn.leetcode.l67;

/**
 * 67 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Main {
    public static void main(String[] args) {
        String a = "1010";
        String b = "11";
        System.out.println(addBinary(a,b));
    }
    // 二进制求和
    public static String addBinary(String a, String b){
        StringBuffer sb = new StringBuffer();
        int flag = 0;
        for (int i=a.length()-1, j=b.length()-1; i>=0 || j>=0; i--, j--){
            int numa = i>=0 ? a.charAt(i)-'0' : 0;
            int numb = j>=0 ? b.charAt(j)-'0' : 0;
            int tempSum = numa + numb + flag;
            if (tempSum < 2){
                sb.append(tempSum);
                flag = 0;
            }
            else if (tempSum == 2){
                sb.append(0);
                flag = 1;
            }
            else {
                sb.append(1);
                flag = 1;
            }
        }
        if (flag == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
