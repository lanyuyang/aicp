package com.iflytek.tr.nlp.learn.leetcode.l463;

import java.util.Arrays;

/**
 * 463 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 *
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Main {
    static int[][] landArr =new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    static int[][] landArr1 =new int[][]{{1,0}};
    public static void main(String[] args) {
        // 二维数组初始化

        System.out.println(islandPerimeter(landArr1));
    }
    public static int islandPerimeter(int[][] grid) {
        // 统计1的个数N  N*4
        // 计算没个1的上下左右 有1的个数num  ， 如果有则减去 num
        int num = 0;
        int minusNum = 0;
        for (int i=0; i< grid.length; i++){
            for (int j=0; j< grid[0].length; j++){
                int tempNum = grid[i][j];
                if (tempNum == 1){
                    num ++;
                    minusNum += neighbourCount(i, j, grid);
                }
            }
        }
        int result = num *4 - minusNum;
        return result;
    }

    public static int neighbourCount(int x , int y, int[][] grid){
        int count = 0;
        if ( x-1 >= 0 && grid[x-1][y] == 1){
            count ++;
        }
        if ( x+1 < grid.length && grid[x+1][y] == 1){
            count++;
        }
        if ( y-1 >= 0 && grid[x][y-1] == 1){
            count++;
        }
        if ( y+1 < grid[0].length && grid[x][y+1] == 1){
            count++;
        }
        return count;
    }
    public static void printArr(int[][] landArr){
        System.out.println(Arrays.toString(landArr));
        // 二维数组打印
        System.out.println("b:"+Arrays.deepToString(landArr));
    }
}
