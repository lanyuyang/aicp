package com.iflytek.tr.nlp.learn.huawei.src.AA括号的匹配栈;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//测试的组数
		while(n!=0){
			String str=sc.next();
			Stack<Character> stack=new Stack<Character>();
			if(str.length()%2!=0)//如果字符串长度是奇数，肯定不匹配
				System.out.println("No");
			else{
				for(int i=0;i<str.length();i++){
					if(stack.isEmpty()){
						stack.push(str.charAt(i));
					}else if(stack.peek()=='['&&str.charAt(i)==']'||stack.peek()=='('&&str.charAt(i)==')'){
						stack.pop();
					}else{
						stack.push(str.charAt(i));
					}
				}
				if(stack.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
				n--;
			}			
		}
	}
}
