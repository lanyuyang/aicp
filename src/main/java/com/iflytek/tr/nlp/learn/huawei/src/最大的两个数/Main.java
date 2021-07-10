package com.iflytek.tr.nlp.learn.huawei.src.最大的两个数;//未完待续

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			int row=4;
			int col=5;
			int arr[][]=new int[row][col];
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++){
					arr[i][j]=sc.nextInt();
				}
			int[][] res=Solution(arr);
			//打印输出
			for(int i=0;i<2;i++){
				for(int j=0;j<res[0].length;j++){
					System.out.print(arr[i][j]+" ");
				}	
				System.out.println();
			}
		}						
	}
	public static int[][] Solution(int[][] arr){//对矩阵处理
		for(int i=0;i<arr[0].length;i++){
			for(int p=0;p<arr.length-1;p++)
				for(int q=0;q<arr.length-p-1;q++)
					if(arr[q][i]<arr[q+1][i]){
						int temp=arr[q][i];
						arr[q][i]=arr[q+1][i];
						arr[q+1][i]=temp;
					}
		}
		return arr;
	}
}
