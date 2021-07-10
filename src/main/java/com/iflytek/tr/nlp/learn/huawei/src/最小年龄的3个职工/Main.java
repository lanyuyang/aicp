package com.iflytek.tr.nlp.learn.huawei.src.最小年龄的3个职工;//没有完成

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void  main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null){
			int N=Integer.parseInt(line);
			String arr[][]=new String[N][3];
			for(int i=0;i<N;i++)
				arr[i]=br.readLine().split(" ");
			String[] res=Solution(arr);//将年龄升序排序，并另外存储，res={6,15,65,79,100}
			for(int i=0;i<3;i++){
				daYin(arr,res[i]);//调用打印函数，打印最小的3个
			}
		}
	}
	public static String[] Solution(String[][] arr){
		String[] res=new String[arr.length];
		int abc[]=new int[arr.length];//将字符串转换成int数字，进行排序
		for(int i=0;i<arr.length;i++){
			abc[i]=Integer.parseInt(arr[i][2]);			
		}
		Arrays.sort(abc);//升序排列	
		
		for(int i=0;i<res.length;i++){//将数字转换成字符串
			res[i]=Integer.toString(abc[i]);
		}		
		return res;
	}
	public static void daYin(String[][] arr,String num){
		for(int i=0;i<arr.length;i++){
			if(num.compareTo(arr[i][2])==0)
				System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
		}	
	}
}
