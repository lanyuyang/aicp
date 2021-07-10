package com.iflytek.tr.nlp.learn.huawei.src.华为;

import java.util.Scanner;

public class deleteNum {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int N=sc.nextInt();
			int index=0;
			for(int i=2;i<=N;i++)
				index=(index+3)%i;
			System.out.println(index);
		}
		sc.close();
	}
}
/*
 * 题目：有一个数组a[N]顺序存放0-N，要求没隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。 
输入描述：每组数据为一行一个整数n(小于等于1000)，为数组成员数,如100，则对a[999]进行计算。 
输出描述：一行输出最后一个被删掉的数的原始下标位置。 
输入例子：8 
输出：6 
思路： 
解法一：模拟真的一个环，然后一步一步的按着题目上面的操作，这种方法比较简单，但是需要有O(n)的空间复杂度。 
解法二：使用使用递推公式，f(n,m)=(f(n-1,m)+m)%n,这里的f(n,m)表示每次在n个数字0，1，…，n-1中每次删除第m个剩下的。下面给出证明：

在n个数字中第一个被删的是k,k=(m-1)%n，删除k后是0,1,…,k-1,k+1,…,n-1。下一次从k+1开始，反转过来就是k+1,…,n-1,0,1,…,k-1。
这也是一个序列，但是和之前的不一样他是从k+1开始计数，这里我们把他记做f’(n-1,m)。这里有f(n,m)=f’(n-1,m)。

我们这里可以把k+1,…,n-1,0,1,…,k-1 的序列，映射成0,1,…,n-2。这样就和我们之前的一样了。可以得到映射公式p(x)=(x-k-1)%n,
从有映射到左就有p’(x)=(x+k+1)%n。所以代入上面的公式有f’(n-1,m)=p’(f(n-1,m))=(f(n-1,m)+k+1),把k=(m-1)%n就有f(n,m)=(f(n-1,m)+m)%n。
*/
