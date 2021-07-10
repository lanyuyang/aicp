/*
 * 输入描述:
每组数据输入一个字符串，字符串最大长度为100，
且只包含字母，不可能为空串，区分大小写。

输出描述:
每组数据一行，按字符串原有的字符顺序，
输出字符集合，即重复出现并靠后的字母不输出。*/
package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ziFuJiHe {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			char[] c=sc.next().toCharArray();
			StringBuffer sb=new StringBuffer();
			Set<Character> set=new HashSet<Character>();
			for(int i=0;i<c.length;i++){
				if(set.add(c[i]))//set用于判断不重复就可以
					sb.append(c[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
