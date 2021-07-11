package com.iflytek.tr.nlp.learn.leetcode.l5;

/**
 * 5. 最长回文子串
 *  采用中心扩散算法
 *
 *  两种情况
 * 一种是回文子串长度为奇数（如aba，中心是b）
 * 另一种回文子串长度为偶数（如abba，中心是b，b）
 *
 * 循环遍历字符串 对取到的每个值 都假设他可能成为最后的中心进行判断
 *
 */
public class Main1 {
    static String res = "";
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 回文子串长度是奇数
            helper(i, i, s);
            // 回文子串长度是偶数
            helper(i, i + 1, s);
        }
        return res;
    }

    public static void helper(int m, int n, String s) {
        // m是左边界  n是右边界
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        // 注意此处m,n的值循环完后  是恰好不满足循环条件的时刻
        // 此时m到n的距离为n-m+1，但是mn两个边界不能取 所以应该取m+1到n-1的区间  长度是n-m-1
        if (n - m - 1 > res.length()) {
            // 要取[m+1,n-1]这个区间
            res = s.substring(m + 1, n);
        }
    }
}
