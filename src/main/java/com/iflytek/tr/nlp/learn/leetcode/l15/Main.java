package com.iflytek.tr.nlp.learn.leetcode.l15;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 15.三个数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 超时
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    // 可以将三个数之和等于0的转换成两个数之和==target
    public static List<List<Integer>> threeSum(int[] nums) {
        // 1、升序排序
        Arrays.sort(nums);
        // 2、双指针， 指向首尾， 当两值相加小于目标值， 则left加1， 当大于目标值， 则right-1. 且跳过重复元素
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            int target = -nums[i];
            int left = 0;
            int right = nums.length -1;
            while (left < right){
                if (left == i){
                    left ++;
                    continue;
                }
                if (right == i){
                    right --;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(-target);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    Collections.sort(subList);
                    lists.add(subList);
                    left++;
                    right--;
                }
                if (sum < target){
                    left++;
                }
                if (sum > target){
                    right--;
                }
            }
        }
        // 3、List<List<Integer>>去重
        lists = lists.stream().distinct().collect(Collectors.toList());
        return lists;
    }





    public static void isRepeat(){
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(1);
        sub1.add(2);
        sub1.add(3);

        List<Integer> sub2 = new ArrayList<>();
        sub2.add(1);
        sub2.add(3);
        sub2.add(2);


        if (checkDiffrent1(sub1, sub2)){
            System.out.println("相同");
        }else {
            System.out.println("不同");
        }
    }

    /**
     * 判断集合相等
     * 判断两个集合是否完全相同，完全相同返回true， 有一个不同返回false
     * @param list
     * @param list1
     * @return
     */
    private static boolean checkDiffrent1(List<Integer> list, List<Integer> list1) {
        return !list.retainAll(list1);
    }

    /**
     * 判断集合相等
     * 判断两个集合是否完全相同，完全相同返回true， 有一个不同返回false
     * @param list
     * @param list1
     * @return
     */
    private static boolean checkDiffrent2(List<String> list, List<String> list1){
        return list.stream().sorted().collect(Collectors.joining()).equals(list1.stream().sorted().collect(Collectors.joining()));
    }
}
