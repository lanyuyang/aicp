package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

public class jinZhiZhuanHuan {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] str=new String[N];
		for(int i=0;i<str.length;i++)
			str[i]=sc.next();
		Solution(str);
	}
	//进制转换处理
	public static void Solution(String[] str){
		int[] arr=new int[str.length];
		for(int i=0;i<str.length;i++){
			str[i]=str[i].substring(2);
			arr[i]=Integer.parseInt(str[i],2);
		}
		for(int i=0;i<arr.length;i++)//以字符串形式输出
			System.out.print(Integer.toString(arr[i])+" ");
	}
}
