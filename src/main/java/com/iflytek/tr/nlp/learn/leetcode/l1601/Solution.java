package com.iflytek.tr.nlp.learn.leetcode.l1601;

/**
 *  交换数字
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 */
public class Solution {
    public static void main(String[] args) {

        int[] numbers = new int[]{1,2};
        swapNumbers(numbers);
    }
    public static int[] swapNumbers(int[] numbers) {


        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];

        return numbers;
    }
}
