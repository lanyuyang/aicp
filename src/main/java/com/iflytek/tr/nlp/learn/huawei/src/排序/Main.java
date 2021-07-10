package com.iflytek.tr.nlp.learn.huawei.src.排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int N=sc.nextInt();
			int[] arr=new int[N];
			for(int i=0;i<arr.length;i++)
				arr[i]=sc.nextInt();
			
			int[] res=Solution(arr);
			for(int i=0;i<arr.length;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
	}
	public static int[] Solution(int[] arr){
		Arrays.sort(arr);
		return arr;
	}
}
