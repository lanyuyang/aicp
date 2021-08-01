package com.iflytek.tr.nlp.learn.leetcode.l58;

/**
 * 58 最后一个单词的长度
 *
 * 给你一个字符串 s，由若干单词组成，单词之间用单个或多个连续的空格字符隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = " "
 * 输出：0
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        String s = "  ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s){
        String[] wordArr = s.split(" ");
        if (wordArr.length == 0){
            return 0;
        }
        return wordArr[wordArr.length-1].length();
    }
}
