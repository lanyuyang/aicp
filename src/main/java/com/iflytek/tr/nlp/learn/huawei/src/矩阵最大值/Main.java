package com.iflytek.tr.nlp.learn.huawei.src.矩阵最大值;//注意打印每行最后有没有空格，本题没有空格

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int row=sc.nextInt();//行
			int col=sc.nextInt();//列
			int arr[][]=new int[row][col];
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++){
					arr[i][j]=sc.nextInt();
				}
			int[][] res=Solution(arr);
			//打印输出
			for(int i=0;i<res.length;i++){
				for(int j=0;j<res[0].length;j++){
					System.out.print(arr[i][j]);
					if(j<res[0].length-1){
						System.out.print(" ");
					}
				}	
				System.out.println();
			}
		}
	}
	public static int[][] Solution(int[][] arr){//对矩阵处理
		for(int i=0;i<arr.length;i++){
			int sum=0;
			int max=0;
			for(int j=0;j<arr[0].length;j++){
				sum+=arr[i][j];
				if(max<arr[i][j])
					max=arr[i][j];//找到最大值
			}
			//最大值替换
			for(int j=0;j<arr[0].length;j++){
				if(max==arr[i][j]){
					arr[i][j]=sum;
					break;//找到第一个就跳出
				}
			}
		}
		return arr;
	}
}
