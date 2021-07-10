package com.iflytek.tr.nlp.learn.huawei.src.统计单词;//未完待续

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			String string=sc.next();			
			int[] res=Solution(string);
			for(int i=0;i<res.length;i++){
				System.out.print(res[i]);
				if(i<res.length-1)
					System.out.print(" ");
			}
		}
	}
	public static int[] Solution(String string){
		//String new_string=string.substring(0, string.lastIndexOf("."));//从开始位置到.之前进行截断
		String new_string=string.replace(".", "");
		String[] str=new_string.split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i]=str[i].toString().length();
		}
		//System.out.print(arr.length+" ");
		return arr;
	}
}
