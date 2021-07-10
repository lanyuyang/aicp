package com.iflytek.tr.nlp.learn.huawei.src.对称矩阵;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
			while(true){
				int N=sc.nextInt();				
				int arr[][]=new int[N][N];//或者：int[][] arr=new int[N][N];
				for(int i=0;i<N;i++)
					for(int j=0;j<N;j++)
						arr[i][j]=sc.nextInt();
				if(duiChen(arr))
					System.out.println("Yes!");
				else
					System.out.println("No!");
			}					
	}
	public static boolean duiChen(int[][] arr){
		int N=arr.length;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				if(arr[i][j]!=arr[j][i])
					return false;
			}
		return true;
	}
}
