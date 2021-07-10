package com.iflytek.tr.nlp.learn.huawei;

import java.util.ArrayList;

/**
 * Created by yylan on 2021/2/22.
 * 最大子数组问题
 * 最大子数组的概念：给定一个数组，若有一个连续的子数组，其中所有元素之和最大，则称之为最大子数组。
 如[1,-2,3,4,-1,0,2,-5,2,-1]，该数组的最大子数组为[3,4,-1,0,2]，元素之和为8。
 问题：求解最大子数组的元素和
 输入：int[] arr
 输出：int sum
 这个问题可以用动态规划来解决。令int[] f = new int[arr.length]。f中存放最大子数组的元素和，如f[i]存放arr[0],arr[1]...arr[i]的最大子数组。
 对于f[i]而言，只有三种情况可以构成最大子数组：
 1、f[i-1]的结果即为最大子数组的元素和
 2、arr[i]单独一个元素为最大子数组
 3、最大子数组同时包含arr[i]与arr[i]之前的元素，设为subSum
 即f[i]=max(f[i-1],arr[i],subSum)。
 subSum的求解也很容易，即从arr[i]开始，向arr[0]方向逐个元素累加，在累加的过程中同时判断，一旦结果大于max(f[i-1],arr[i])，则存储最大值。
 subSum求解完毕后f[i]也随之解得，最后f[arr.length-1]即为所求结果。
 */
public class Test6 {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,4,-1,0,2,-5,2,-1};
        int res = getMax(nums);
        System.out.println(res);
    }
    /**
     * @param arr
     * @return
     */
    public static int getMax(int[] arr){
        int[] f = new int[arr.length];
        f[0] = arr[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<arr.length;i++){
            int max;
            if(f[i-1]<arr[i]){
                max = arr[i];
                list.clear();
                list.add(arr[i]);
            }else
                max = f[i-1];
            int sum = 0,index = 0;
            boolean tag = false;
            for(int j=i;j>=0;j--){
                sum += arr[j];
                if(max<sum){
                    max = sum;
                    index = j;
                    tag = true;
                }
            }
            if(tag){
                list.clear();
                for(int m=index;m<=i;m++){
                    list.add(arr[m]);
                }
            }
            f[i] = max;
        }
        System.out.println(list);
        return f[arr.length-1];
    }
}
