package com.iflytek.tr.nlp.learn.leetcode.l1;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 1、两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(JSON.toJSON(res));
    }

    /**
     * 采用查找表法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        hashMap.put(nums[0],0);
        for (int i=1; i< nums.length; i++){
            int diffValue =target - nums[i];
            if (hashMap.containsKey(diffValue)){
                return new int[]{hashMap.get(diffValue), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
