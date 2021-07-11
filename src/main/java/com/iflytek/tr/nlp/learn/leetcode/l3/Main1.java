package com.iflytek.tr.nlp.learn.leetcode.l3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *  滑动窗口正确版
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }
    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        Set<Character> set = new HashSet<>();
        // 定义滑动窗口左右边界 右边界初始值为-1，表示刚开始窗口还不存在
        int left = 0;
        int right = -1;
        while (left < s.length()){
            // 向右移动一个元素
            if (right +1 < s.length() && !set.contains(s.charAt(right +1))){
                set.add(s.charAt(right +1));
                right ++;
            }else {
                set.remove(s.charAt(left));
                left ++;
            }
            res = Math.max(res, right - left +1);
        }
        return res;
    }
}
