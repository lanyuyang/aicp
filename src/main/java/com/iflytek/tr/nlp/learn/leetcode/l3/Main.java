package com.iflytek.tr.nlp.learn.leetcode.l3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 复杂度太高， 超时
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }
    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        for (int i=s.length(); i>0; i--){
            List<String> subStrList = getFixedSubstring(s, i);
            for (int j=0; j< subStrList.size(); j++){
                if (!containRepeatChar(subStrList.get(j))){
                    return subStrList.get(j).length();
                }
            }
        }
        return 0;
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

    /**
     * 是否包含重复字符
     * @param str
     * @return
     */
    public static boolean containRepeatChar(String str){
        if(str==null||str.isEmpty()){
            return false;
        }
        char[] elements=str.toCharArray();
        for(char e:elements){
            if(str.indexOf(e)!=str.lastIndexOf(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断区间内是否包含重复字符
     * @param str
     * @return
     */
    public static boolean allUnique(String str, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i=start; i<=end; i++){
            if (set.contains(str.charAt(i))){
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }
}
