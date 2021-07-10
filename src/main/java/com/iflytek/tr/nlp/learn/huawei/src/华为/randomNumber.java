package com.iflytek.tr.nlp.learn.huawei.src.华为;
/*

明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。 
      
  Input Param  
       n               输入随机数的个数      
   inputArray      n个随机整数组成的数组  
        
  Return Value 
       OutputArray    输出处理后的随机整数
  输入描述:

输入多行，先输入随机整数的个数，再输入相应个数的整数


输出描述:

返回多行，处理后的结果*/

import java.util.Arrays;
import java.util.Scanner;

public class randomNumber {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);		
		while(sc.hasNext()){
			int N=sc.nextInt();
			int[] arr=new int[N];
			for(int i=0;i<arr.length;i++)
				arr[i]=sc.nextInt();
			Arrays.sort(arr);
			
			//去重输出
			System.out.println(arr[0]);
			for(int i=1;i<arr.length;i++){
				if(arr[i]!=arr[i-1])
					System.out.println(arr[i]);
			}
		}
		sc.close();
	}
}
