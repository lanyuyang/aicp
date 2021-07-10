package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 翻转文章片段
 *
 * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。例如输入字符串"I am a developer. "，区间[0,3]，则输出"developer. a am I"。
 *
 * 输入描述:
 *
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为翻转起始单词下标(下标从0开始)，第三个参数为结束单词下标。
 *
 * 输出描述:
 *
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
 *
 * 示例1
 *
 * 输入
 *
 * I am a developer.
 *
 * 1
 *
 * 2
 *
 * 输出
 *
 * I a am developer.
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String[] arrStr = words.split(" ");
        for (int i=0; i< start; i++){
            System.out.print(arrStr[i] + " ");
        }
        for (int i=end; i>= start; i--){
            System.out.print(arrStr[i] + " ");
        }
        for (int i= end +1; i< arrStr.length; i++){
            System.out.print(arrStr[i] + " ");
        }
    }

}
