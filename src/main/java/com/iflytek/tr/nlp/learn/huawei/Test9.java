package com.iflytek.tr.nlp.learn.huawei;

/**
 * Created by yylan on 2021/2/22.
 * 勾股定理
 * 给定一个区间，找出所有的可以组成a*a + b*b = c*c的组合，例如[2,10]，可以找出两组：3 4 5；6 8 10
 */
public class Test9 {
    public static void main(String[] args) {
        int num = 100;
//        getResult(num);
        gouguNum(2,10);
    }
    //
    public static void gouguNum (int start, int end){
        for(int i=start;i<=end;i++)
            for(int j=i+1;j<=end;j++)
                for(int k=j+1;k<=end;k++)
                {
                    if(k*k==i*i+j*j)
                    {
                        System.out.println(i+"\t"+j+"\t"+k);
                    }
                }
    }
    /**
     * 已知直角三角形的斜边是某个整数，并且要求另外两条边也必须是整数。
     求满足这个条件的不同三个直角三角形的个数。
     入参 ： 斜边值   出参：直角三角形数量
     * @param n
     */
    public static void getResult(int n){
        int result = 0;
        for(int i=1;i<=n;i++){
            for(int j=n-i+1;j<n;j++) {
                int temp =i*i+j*j;
                if(temp==n*n&&j>=i)
                    result++;
            }
        }
        System.out.println(result);
    }
}
