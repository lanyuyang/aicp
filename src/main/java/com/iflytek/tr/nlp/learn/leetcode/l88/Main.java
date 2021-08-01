package com.iflytek.tr.nlp.learn.leetcode.l88;

/**
 * 88 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {

    }
    // 官方答案
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n>0&&m>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[n+m-1]=nums1[m-1];
                m--;
            }else{
                nums1[n+m-1]=nums2[n-1];
                n--;
            }
        }
        for(int i=0;i<n;i++){
            nums1[i]=nums2[i];
        }
    }
}
