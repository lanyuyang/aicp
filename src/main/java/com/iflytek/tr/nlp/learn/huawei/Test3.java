package com.iflytek.tr.nlp.learn.huawei;

import java.util.Scanner;

/**
 * Created by yylan on 2021/2/22.
 * 巧妙统计二进制数中1的个数
 * 二进制数中，每一位非0即1。要计算一个二进制数中1的个数，不妨设其位数为N，首先最容易想到的一种解法就是逐位判断是否为1，并记录。那么如何逐位判断呢？可以通过将该数除以2，判断其余数是否为1。当然效率更高一些的方式是先将该数与1作与运算，结果不为0则计数，然后将该数右移，之后重复上述步骤。这种方式的时间复杂度为O(N)。

 然而，对于这个问题，O(N)并不是最好最快的解法。有没有可能将复杂度缩小到只与1的个数有关？

 当然是可能的。考虑二进制数1000。对于该数，将其与1000-0001的差值，即0111作一次与运算后会将该位置为0。再考虑10100。同样，将其与10100-00001的差值，即10011作一次与运算后得到10000，这一次运算将10100最低位的1置为了0。再进行一次同样的运算后，会将剩下的1也置为0。因此，每一次将数与其自减1后的结果作与运算都是在将该数最右侧的1置为0。所以在进行了次数为该数中1的个数次运算后，该数变为0，次数即为1的个数。
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();
        int res = countOne(num);
        System.out.println(res);
    }
    public static int countOne(long num){
        int count = 0;
        while(num!=0){
            num &= --num;
            count++;
        }
        return count;
    }
}
