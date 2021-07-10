package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 组最大数字
 * 给出几组字符串的数字，需要获得组成的最大数字
 *
 * 比如输入123，546，8，32，输出854632123
 */
public class Test5 {
    public static List<String> resList = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        srcStr = srcStr.replaceAll(" ", "");
        String[] arr = srcStr.split(",|，");
        int[] arrInt = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        permutation("",arrInt, arr.length);
        int max = Integer.parseInt(resList.get(0));
        for (int i=1; i< resList.size(); i++){
            int num = Integer.parseInt(resList.get(i));
            if (max < num){
                max = num;
            }
        }
        System.out.println(max);
    }

    // 排列组合
    public static void permutation(String s, int[] ia, int n) {
        if(n == 1) {
            for(int i = 0; i < ia.length; i++) {
//                System.out.println(s+ia[i]);
                resList.add(s+ia[i]);
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
