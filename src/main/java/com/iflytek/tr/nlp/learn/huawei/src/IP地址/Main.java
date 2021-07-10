package com.iflytek.tr.nlp.learn.huawei.src.IP地址;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int N=sc.nextInt();
			String[] str=new String[N];
			for(int i=0;i<str.length;i++){
				str[i]=sc.next();
			}	
			Solution(str);
		}
	}
	public static void Solution(String[] str){
		for(int i=0;i<str.length;i++){
			int[] arr=new int[4];
			int count=0;//总共4段
			String[] str_split=str[i].split("\\.");
			for(int j=0;j<str_split.length;j++){
				arr[j]=Integer.parseInt(str_split[j]);
				if(arr[j]>=0&&arr[j]<=255)
					count++;
			}
			if(count==4)
				System.out.println("Yes!");
			else
				System.out.println("No!");
		}
	}
}

