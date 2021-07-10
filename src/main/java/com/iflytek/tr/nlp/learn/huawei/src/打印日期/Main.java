/**
只要建立一个数组，用于查表就好,把闰年的情况独立出来，也就是说把二月改一下即可。
而且天数只会最多有366天，也就是加一年而已，完全不用再考虑第二年情况！！
*/
package com.iflytek.tr.nlp.learn.huawei.src.打印日期;//输入第几天，打印年月日

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){ //hasNextInt()方法是判断控制台接收是否为数字
			Demo(sc.nextInt(),sc.nextInt());
		}
	}
	public static void Demo(int a,int b){
		int[] month={31,28,31,30,31,30,31,31,30,31,30,31};
		if(a%4==0&&a%100!=0||a%400==0){
			month[1]=29;
		}
		int i;
		for(i=0;i<month.length;i++){
			if(b<=month[i])
				break;
			else{
				b-=month[i];
			}
		}
		if(i==11&&b>31)
			a++;
		String str=String.format("%d-%02d-%02d", a,i+1,b);
		System.out.println(str);
	}
}
