package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 3、匹配子字符串的个数
 *
 * 给出一个母串，一个子串，母串中包含空格。计算出子串在母串中出现的次数。
 *
 * 例如: 母串：Akk bhah ahb bd，子串ha，输出是2
 */
public class Test9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        String subStr = sc.nextLine();

        srcStr = srcStr.replaceAll(" ", "");

        int length = srcStr.length() - subStr.length();
        int count = 0;
        for (int i=0; i< length; i++){
            String temp = srcStr.substring(i, i+subStr.length());
            if (subStr.equals(temp)){
                count ++;
            }
        }
        System.out.println(count);
    }


}
