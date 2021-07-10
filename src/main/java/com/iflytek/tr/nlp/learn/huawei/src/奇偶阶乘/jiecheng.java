package com.iflytek.tr.nlp.learn.huawei.src.奇偶阶乘;
import java.util.Scanner;

public class jiecheng{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int N=sc.nextInt();
			int y1=0,y2=0;
			for(int i=1;i<=N;i++){
				if(i%2!=0){
					y1+=Demo(i);
				}else{
					y2+=Demo(i);
				}				
			}
			System.out.println(y1+" "+y2);
		}
	}
	public static int Demo(int num){
		int res=1;
		for(int i=1;i<=num;i++){
			res*=i;
		}
		return res;
	}
}