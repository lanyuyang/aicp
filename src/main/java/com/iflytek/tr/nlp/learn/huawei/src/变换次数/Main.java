package com.iflytek.tr.nlp.learn.huawei.src.变换次数;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);		
		while(sc.hasNext()){
			int n=sc.nextInt();
			int count=0;//记录次数
			int flag=0;
			String str1=Integer.toString(n);
			if(str1.length()==1)
				flag=1;			
			while(true){
				int[] res=Demo(n);
				int sum=1;
				for(int i=0;i<res.length;i++)
					sum*=res[i];
				n=sum;
				count++;
				String str=Integer.toString(n);
				if(str.length()==1)
					break;
			}
			if(flag==0)
				System.out.println(count);
			else
				System.out.println(0);
		}
	}
	public static int[] Demo(int n){
		String str=Integer.toString(n);
		int[] arr=new int[str.length()];//建立和整数n等长的数组
		for(int i=0;i<arr.length;i++){
			arr[i]=n%10;
			n=n/10;
		}
		return arr;
	}
}
