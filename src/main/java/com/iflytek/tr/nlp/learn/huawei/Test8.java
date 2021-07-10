package com.iflytek.tr.nlp.learn.huawei;

/**
 * Created by yylan on 2021/2/22.
 * 斐波那契数列及系列问题
 * 斐波那契数列，即 0,1,1,2,3,5,8...，
 * 从第三个数开始，数值为前两个数之和。对于该数列，求解第n项只需要通过迭代即可完成。
 */
public class Test8 {
    public static void main(String[] args) {
        int n= 6;
        int res1 =Fibonacci1(n);
        System.out.println(res1);

        int res2 =Fibonacci2(n);
        System.out.println(res2);
    }


    // 方法1
    public static int Fibonacci1(int n) {
        int left=0,right=1,result=0;
        if(n<0)
            return -1;
        else if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else{
            for(int i=2;i<=n;i++){
                result = left + right;
                left = right;
                right = result;
            }
            return result;
        }
    }

    // 方法2 递归
    public static int Fibonacci2(int n) {
        if(n<0)
            return -1;
        else if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else
            return Fibonacci2(n-1)+Fibonacci2(n-2);
    }

}
