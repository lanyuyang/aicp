package com.iflytek.tr.nlp.learn.leetcode.l5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {

        // 1、采用滑动窗口， 找到子串
        for (int i=s.length(); i>0;i--){
            List<String> subStrList = getFixedSubstring(s, i);
            for (String str:subStrList){
                // 2、判断该子串是不是回文
                if (isHuiwen(str)){
                    return str;
                }
            }
        }

        return "";
    }

    /**
     * 采用滑动窗口寻找
     * @param srcStr 源字符串
     * @param length 需要找到子串的长度
     * @return 返回找到所有子串的列表
     */
    public static List<String> getFixedSubstring(String srcStr, int length){
        List<String> resList = new ArrayList<>();
        // 循环次数
        int count = srcStr.length() - length + 1;
        for (int i=0; i<count; i++){
            String tempStr = srcStr.substring(i, i+length);
            resList.add(tempStr);
        }
        return resList;
    }
    public static boolean isHuiwen(String str){
        // 偶数bb
        if (str.length() % 2 == 0){
            str = str.substring(0, str.length()/2) + "0" + str.substring(str.length()/2, str.length());
        }
        int i = str.length()/2-1;//从字符串中间往左
        int j = str.length()/2+1;//从字符串中间往右
        boolean c = true;//默认为真
        for(;i >= 0 || j < str.length();i--,j++){//遍历整个字符串判断是否为回文
            if(str.charAt(i) != str.charAt(j)){
                c = false;
                break;
            }
            else
                c = true;
        }
        return c;
    }
}
