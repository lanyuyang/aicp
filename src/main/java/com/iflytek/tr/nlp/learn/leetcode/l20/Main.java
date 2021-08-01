package com.iflytek.tr.nlp.learn.leetcode.l20;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        boolean isV = false;
        Stack<Character> stack=new Stack<Character>();
        if(s.length()%2!=0){
            return isV;
        }
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(stack.peek()=='['&&s.charAt(i)==']'||stack.peek()=='('&&s.charAt(i)==')' || stack.peek() == '{'&& s.charAt(i)=='}'){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            isV = true;
        }
        return isV;
    }
}
