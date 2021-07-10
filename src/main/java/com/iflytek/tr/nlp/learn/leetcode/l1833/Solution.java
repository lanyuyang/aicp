package com.iflytek.tr.nlp.learn.leetcode.l1833;

import java.util.Arrays;

/** 1833.雪糕的最大数量
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 *
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 *
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
//        int[] costs = new int[]{1,3,2,4,1};
//        int coins = 7;

        int[] costs = new int[]{7,3,3,6,6,6,10,5,9,2};
        int coins = 56;

//        int[] costs = new int[]{1,6,3,1,2,5};
//        int coins = 20;
        int res = maxIceCream(costs, coins);
        System.out.println(res);
    }
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i=0; i< costs.length; i++){
            if (coins >= costs[i]){
                res ++;
                coins -= costs[i];
            }else {
                break;
            }
        }
      return res;
    }

}
