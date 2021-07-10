package com.iflytek.tr.nlp.learn.huawei.src.矩阵转置;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int N=sc.nextInt();
			int[][] arr=new int[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					arr[j][i]=sc.nextInt();
			
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(arr[i][j]);
					if(j<N-1)//输出最后没有空格
						System.out.print(" ");
				}				
				System.out.println();
			}
		}
	}
}
