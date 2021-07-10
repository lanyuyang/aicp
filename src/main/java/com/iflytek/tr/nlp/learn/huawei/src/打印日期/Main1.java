package com.iflytek.tr.nlp.learn.huawei.src.打印日期;//输入年月日，打印第几天

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int year=sc.nextInt();
			int month=sc.nextInt();
			int day=sc.nextInt();
			int res=iConverDateToDay(year,month,day);
			System.out.println(res);
		}		
	}
	 public static int iConverDateToDay(int year, int month, int day){
		 int[] arr={31,28,31,30,31,30,31,31,30,31,30,31};
		 if(year%4==0&&year%100!=0||year%400==0)//闰年
			 arr[1]=29;
		 int sum=0;
		 for(int i=0;i<month-1;i++){
			 sum+=arr[i];
		 }
		 sum=sum+day;
		 return sum;
	 }	 
}
