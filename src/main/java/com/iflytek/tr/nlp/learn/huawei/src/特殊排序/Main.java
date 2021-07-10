package com.iflytek.tr.nlp.learn.huawei.src.特殊排序;//未完待续

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
			
			Solution(arr);			
		}
	}
	public static void Solution(int[] arr){
		Arrays.sort(arr);
		System.out.println(arr[arr.length-1]);
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.print(arr[i]);
			if(i<arr.length-2)
				System.out.print(" ");
		}
		System.out.println();
	}
}
