/*
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 
表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出描述:
对于每一次询问操作，在一行里面输出最高成绩.*/
package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

public class maxScore {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int N=sc.nextInt();
			int M=sc.nextInt();
			int[] arr=new int[N];
			for(int s=0;s<N;s++){//输入成绩
				arr[s]=sc.nextInt();
			}
			//有M条指令
			for(int i=0;i<M;i++){
				String s=sc.next();
				char C=s.charAt(0);
				int A=sc.nextInt();
				int B=sc.nextInt();
				Solution(arr,C,A,B);
			}
		}
	}
	public static void Solution(int[] arr,char c,int a,int b){
		int begin,end;
		if(c=='Q'){
			end=Math.max(a, b);
			begin=Math.min(a, b)-1;
			int max=arr[begin];
			for(int i=begin;i<end;i++){
				if(max<arr[i])
					max=arr[i];
			}
			System.out.println(max);
		}else if(c=='U')
			arr[a-1]=b;
	}
}
