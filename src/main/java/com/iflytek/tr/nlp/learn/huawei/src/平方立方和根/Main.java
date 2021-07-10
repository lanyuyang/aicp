package com.iflytek.tr.nlp.learn.huawei.src.平方立方和根;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double A=sc.nextInt();
		//求A的平方/立方
		double a=Math.pow(A, 3);
		System.out.println(a);
		//求A的平方根
		double b=Math.sqrt(A);
		System.out.println(b);
		//求立方根需要牛顿迭代法
	}
}
