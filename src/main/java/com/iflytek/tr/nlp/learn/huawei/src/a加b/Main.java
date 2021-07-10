package com.iflytek.tr.nlp.learn.huawei.src.a加b;//实际就是斐波那契数列

import java.util.Scanner;

public class Main{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		int n = in.nextInt();
		long[] fab = new long[n+1];
		fab[0] = 0;
		if(n > 0){
			fab[1] = 1;
		}
		if(n > 1){
			fab[2] = 2;
		}
		for(int i = 3; i <= n; i++){
			fab[i] = fab[i-1] + fab[i-2];
		}
		System.out.println(fab[n]);
		}
	}
}