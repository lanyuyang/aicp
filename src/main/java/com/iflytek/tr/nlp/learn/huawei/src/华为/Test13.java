package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * String加密
 *
 * 给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]，
 *
 * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
 *
 * 输入描述:
 *
 * 第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。
 *
 *
 *
 * 输出描述:
 *
 * 每组测试数据输出一行，表示字符串的密文
 *
 * 示例1
 *
 * 输入
 *
 * 1
 *
 * xy
 *
 * 输出
 *
 * ya
 */
public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        for (int c=0; c< n; c++){
            String srcStr = sc.nextLine();
            for (int i=0; i< srcStr.length(); i++){
                // 获取字符
                char ch = srcStr.charAt(i);
                // 转换ascii码
                int value = charToByteAscii2(ch);
                // 获取应该加的数值
                int offsetValue = getValue(i);
                // 计算得到的ascii数值
                int asc = value + offsetValue;
                if (asc > 122){
                    asc = 96 + (asc - 122);
                }
                // 转换字符
                char chV = byteAsciiToChar(asc);
                // 输出
                System.out.print(chV);
            }
        }

    }

    public static byte charToByteAscii2(char ch)
    {
        byte byteAscii = (byte)ch;
        return byteAscii;
    }

    public static char byteAsciiToChar(int ascii)
    {
        char ch = (char)ascii;
        return ch;
    }

    // 方法2 递归  （使用波那契数列）
    public static int getValue(int n) {
        if(n<0)
            return -1;
        else if(n==0)
            return 1;
        else if(n==1)
            return 2;
        else if(n==2)
            return 4;
        else
            return getValue(n-1)+getValue(n-2) + getValue(n-3);
    }
}
