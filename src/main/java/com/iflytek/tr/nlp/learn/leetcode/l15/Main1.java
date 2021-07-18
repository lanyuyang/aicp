package com.iflytek.tr.nlp.learn.leetcode.l15;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists= threeSum(nums);
        System.out.println(JSON.toJSON(lists));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3){
            return  lists;
        }
        Arrays.sort(nums);
        for (int i=0; i<len; i++){
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0){
                break;
            }
            // 去重
            if (i> 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = len -1;
            while (left < right){
                int sum = nums[i] + nums[left] +nums[right];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 左边去重
                    while (left < right && nums[left]== nums[left+1])
                        left++;
                    // 右边去重
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left ++;
                    right --;
                }
                if (sum < 0){
                    left ++;
                }
                if (sum > 0){
                    right --;
                }
            }
        }
        return lists;
    }
}
