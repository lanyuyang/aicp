package com.iflytek.tr.nlp.learn.codeDemo;

public class Lianxi {
    public static void main(String[] args) {
        char[] chars = {'1'};
        char[] chars1 = {'\u0012'};
        test1();
    }
    private static void test1(){
        char alpha = 'A';
        int foo = 65;
        boolean trueExp = true;
        System.out.println(trueExp ? alpha : 0);
        System.out.println(trueExp ? alpha : foo);
    }
}
