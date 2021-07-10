package com.iflytek.tr.nlp.learn.huawei.src.回文字符串;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			String str=sc.next();
			if(Demo(str)){
				System.out.println("Yes!");
			}else{
				System.out.println("No!");
			}
		}
	}
	public static boolean Demo(String str){
		int i=0,j=str.length()-1;
		while(i<j){
			if(str.charAt(i)==str.charAt(j)){
				i++;
				j--;
			}else
				return false;
		}
		if(i>=j)
			return true;
		return false;
	}
}
