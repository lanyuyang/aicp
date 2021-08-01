package com.iflytek.tr.nlp.learn.leetcode.l14;

/**
 *
 */
public class Main1 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        if (strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for (int i=1; i< strs.length; i++){
            int minLength = Math.min(ans.length(), strs[i].length());
            int j=0;
            for (; j< minLength; j++){
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}
