/*重要
 * 输入：-234,567,890 123,456,789
 * 输出：-111111101
 * 方法重要   多看
 * */
package com.iflytek.tr.nlp.learn.huawei.src.A加B分隔符;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			Demo(sc.next(),sc.next());	
		}
	}
	public static void Demo(String a,String b){
		int sum=stringToInt(a)+stringToInt(b);
		System.out.println(sum);
	}
	public static int stringToInt(String str){
		//分开，转换成数组
		String[] arr=str.split(",");
		
		//每个子串拼接
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		String res=sb.toString();//将StringBuffer转换成String	
		
		//字符串转换成数字      int res=Integer.parseInt(sb.toString());
		int num=Integer.parseInt(res);
		return num;
	}
}
