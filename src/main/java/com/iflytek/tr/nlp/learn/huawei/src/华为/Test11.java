package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

/**
 * 现有一字符串仅由 '('，')'，'{'，'}'，'['，']'六种括号组成。
 *
 * 若字符串满足以下条件之一，则为无效字符串：
 *
 *   ①任一类型的左右括号数量不相等；
 *
 *   ②存在未按正确顺序（先左后右）闭合的括号。
 *
 * 输出括号的最大嵌套深度，若字符串无效则输出0。
 *
 * 0≤字符串长度≤100000
 *
 * 输入描述:
 *
 * 一个只包括 '('，')'，'{'，'}'，'['，']'的字符串
 *
 * 输出描述:
 *
 * 一个整数，最大的括号深度
 *
 * 示例2
 *
 * 输入
 *
 * ([]{()})
 *
 * 输出
 *
 * 3
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("\\[","(")
                .replaceAll("]",")")
                .replaceAll("\\{","(")
                .replaceAll("}",")");
        int cnt = 0, max = 0, i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            max = Math.max(max, cnt);
        }
        sc.close();
        System.out.println(max);
    }
}
