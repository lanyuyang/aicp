package com.iflytek.tr.nlp.learn.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yylan on 2021/2/20.
 */
public class demo {
    public static void main(String[] args) {
        test1();
    }
    // 求最长无重复子串
    public static void test1(){
        int[] a1 = {2,2,3,4,3};
        int res = maxLength(a1);
        System.out.println(res);
    }
    public static int maxLength (int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<arr.length; i++){
            int num = arr[i];
            if (!list.contains(num)){
                list.add(num);
            }
        }
        return list.size();
    }
}
