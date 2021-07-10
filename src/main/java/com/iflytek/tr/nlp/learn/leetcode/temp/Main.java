package com.iflytek.tr.nlp.learn.leetcode.temp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private  static  ArrayList<String> list = new ArrayList<String>();
        public static void main(String[] args) {
            char[] chs = {'a','b','c'};
            // 全排列
            arrange(chs, 0, chs.length);
            // 组合
            select(chs, list, 3);
            System.out.println(list);
        }
        // 全排列
        public static void arrange(char[] chs, int start, int len){
            if(start == len-1){
                for(int i=0; i<chs.length; ++i)
                    System.out.print(chs[i]);
                System.out.println();
                return;
            }
            for(int i=start; i<len; i++){
                char temp = chs[start];
                chs[start] = chs[i];
                chs[i] = temp;
                arrange(chs, start+1, len);
                temp = chs[start];
                chs[start] = chs[i];
                chs[i] = temp;
            }
        }

    /**
     * 从数组中选出所有组合
     * @param source
     * @param arrayList
     * @param num
     */
    public static void select(char[] source, List<String> arrayList, int num) {
        int lg = source.length;
        char[] temp = new char[num];
        System.arraycopy(source, 0, temp, 0, num);
        // 首次填充数组
        arrayList.add(new String(temp));
        // 逐个(位置)替换方式实现不重复全选
        for (int i = num; i < lg; i++) {
            for (int j = 0; j < num; j++) {
                char tempChar = temp[j];
                temp[j] = source[i];
                arrayList.add(new String(temp));
                temp[j] = tempChar;
            }
        }
    }

}
