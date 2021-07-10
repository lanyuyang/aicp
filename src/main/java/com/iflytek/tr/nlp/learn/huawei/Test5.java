package com.iflytek.tr.nlp.learn.huawei;

import com.iflytek.tr.nlp.learn.huawei.po.ListNode;

import java.util.ArrayList;

/**
 * Created by yylan on 2021/2/22.
 * 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。

 示例 1：
 输入： 1->2
 输出： false
 示例 2：
 输入： 1->2->2->1
 输出： true
 */
public class Test5 {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while(i < j){
            if(list.get(i++).intValue() != list.get(j--).intValue()){
                return false;
            }
        }
        return true;
    }
}
