package com.iflytek.tr.nlp.learn.leetcode.l0807;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> lists = new ArrayList<String>();

    public static void main(String[] args) {
        String S = "qwe";
        String[] resArr = permutation(S);
        for (int i=0; i< resArr.length; i++){
            System.out.println(resArr[i]);
        }
    }
        public static String[] permutation(String S) {
            if(S.equals("")){
                String[] ret= new String[1];
                ret[0]="";
                return ret;
            }
            char[] chars = S.toCharArray();
            dfs11(chars, 0, chars.length - 1);
            String[] ret = new String[lists.size()];
            for (int i = 0; i < lists.size(); i++) {
                ret[i] = lists.get(i);
            }
            return ret;
        }

        public static void dfs11(char[] chars, int i, int n) {
            if (i == n) {
                lists.add(new String(chars));
            }
            for (int k = i; k <= n; k++) {
                // change the char position
                swap(chars, i, k);
                dfs11(chars, i + 1, n);
                swap(chars, i, k);
            }
        }
        public static void swap(char[] chars, int i, int j) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
}
