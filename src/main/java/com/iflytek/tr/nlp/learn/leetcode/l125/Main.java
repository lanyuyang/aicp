package com.iflytek.tr.nlp.learn.leetcode.l125;

import java.util.Locale;

/**
 * 125 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        String str = ".,";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s){
        s = s.toLowerCase().replaceAll(" ","");
        if (s.length() == 1){
            return true;
        }
        if ("".equals(s)){
            return true;
        }
        for (int i=0, j=s.length() -1; i<=j; i++, j--){
            while (!isCorrChar(s.charAt(i))){
                if (i >= j){
                    break;
                }
                i++;
            }
            while (!isCorrChar(s.charAt(j))){
                if (j <= i){
                    break;
                }
                j--;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    // 判断是否是字母和数字
    public static boolean isCorrChar(char c){
        String str = String.valueOf(c);
        String regx = "^[a-zA-Z0-9]+$";
        if (str.matches(regx)){
            return true;
        }
        return false;
    }

    /**
     * 官方的答案
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
