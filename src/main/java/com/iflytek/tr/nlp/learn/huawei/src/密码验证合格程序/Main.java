package com.iflytek.tr.nlp.learn.huawei.src.密码验证合格程序;//未完待续

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String str=sc.next();
			//1、判断位数a
			if(str.length()>=8){
				int a=1;
			}
			
		}
	}
	public static int Demo1(String str){
		int a1=0,a2=0,a3=0,a;
		for(int i=0;i<str.length();i++){
			if(String.valueOf(str.charAt(i)).matches("[a-z]"))
				a1=1;
			if(String.valueOf(str.charAt(i)).matches("[0-9]"))
				a2=1;
			if(String.valueOf(str.charAt(i)).matches("[A-Z]"))
				a3=1;
		}
		return a=a1&a2&a3;
	}
	public static void Demo2(String str){
		
	}
}

