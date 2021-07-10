package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 5、求出排列的指定排序的序列
 *
 * 例如由前k个数组成的排列中的第n个排列
 *
 * 例如k= 4，n =4 输出1342 说明1234 1243 1324 1342 1423
 */
public class Test10 {
    public static List<Integer> resList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = sc.nextInt();
        int[] arrs = new int[num];
        for (int i=0; i< num; i++){
            arrs[i] = i+1;
        }
        permutation("", arrs, arrs.length);

        System.out.println(resList.get(n -1));
    }
    // 排列组合
    public static void permutation(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
//                System.out.println(s+ia[i]);
                String res = s+ia[i];
                resList.add(Integer.parseInt(res));
            }
        } else {
            for(int i = 0; i < ia.length; i++) {
                String ss = "";
//                ss = s+ia[i]+", ";
                ss = s+ia[i];
                //建立没有第i个元素的子数组
                int[] ii = new int[ia.length-1];
                int index = 0;
                for(int j = 0; j < ia.length; j++) {
                    if(j != i) {
                        ii[index++] = ia[j];
                    }
                }

                permutation(ss, ii, n-1);
            }
        }
    }
}
