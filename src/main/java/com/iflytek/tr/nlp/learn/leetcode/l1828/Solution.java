package com.iflytek.tr.nlp.learn.leetcode.l1828;

/** 1828. 统计一个圆中点的数目
 * 给你一个数组 points ，其中 points{i} = {xi, yi} ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 *
 * 同时给你一个数组 queries ，其中 queries{j} = {xj, yj, rj} ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 *
 * 对于每一个查询 queries{j} ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 *
 * 请你返回一个数组 answer ，其中 answer{j}是第 j 个查询的答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3},{3,3},{5,3},{2,2}};

        int[][] queries = new int[][]{{2,3,1},{4,3,1},{1,1,2}};


        int[] res = countPoints(points, queries);
        for (int c=0; c < res.length; c++){
            System.out.print (res[c] +" ");
        }

    }
    // 只要点到圆心的距离小于等于半径就行
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] resPoint = new int[queries.length];
        for (int i=0; i< queries.length; i++){
            int count = 0;
            int x = queries[i][0];
            int y = queries[i][1];

            int r = queries[i][2];

            for (int j=0; j<points.length; j++){
                int x1 = points[j][0];
                int y1 = points[j][1];

                int x0 = Math.abs(x-x1);
                int y0 = Math.abs(y-y1);
                double res = Math.sqrt(x0*x0 + y0*y0);
                if (res <= r){
                    count ++;
                }
            }
            resPoint[i] = count;
        }
        return resPoint;
    }
}
