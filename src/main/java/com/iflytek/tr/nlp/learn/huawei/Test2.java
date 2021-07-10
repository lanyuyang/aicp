package com.iflytek.tr.nlp.learn.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yylan on 2021/2/22.
 * 3、特定和的子序列

 给出一个数组和一个固定SUM，求出连续元素和为sum。
 例如：[1,2,3,4,5,6,7,8]  sum = 10输出是1 2 3 4；sum= 15 输出是1 2 3 4 5；4 5 6；7 8。
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int sum = 15;
        /**
         *  方法1
         */
        for (int i =0; i< nums.length; i++){
            int temp = 0;
            List list = new ArrayList();
            for (int j=i; j< nums.length; j++){
                temp = temp + nums[j];
                list.add(nums[j]);
                if (temp == sum){
                    for (int n=0; n< list.size(); n++){
                        System.out.print(list.get(n)+" ");
                    }
                    System.out.println();
                }
            }
        }
    }



}
