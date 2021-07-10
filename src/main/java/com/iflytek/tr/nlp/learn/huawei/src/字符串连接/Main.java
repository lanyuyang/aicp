package com.iflytek.tr.nlp.learn.huawei.src.字符串连接;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){//使用hasNext()检查序列中是否还有元素。
			/*next方法不能得到带空格的字符串而nextLine（）方法的结束符只是Enter键，
			即nextLine（）方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的。*/
			String[] str=sc.nextLine().split(" ");
			System.out.println(str[0]+str[1]);
		}
	}
}

//public static void Solution(String[] str){//实现字符串的连接
//for(int i=1;i<str.length;i++){
//	str[i]=str[i-1].concat(str[i]);
//}
//System.out.println(str[str.length-1]);
//}
