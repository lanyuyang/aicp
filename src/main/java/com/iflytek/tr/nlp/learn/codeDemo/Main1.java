package com.iflytek.tr.nlp.learn.codeDemo;

public class Main1 {
    public static void main(String[] args) {
        test1();
    }

    /**
     * https://blog.csdn.net/qq_41115379/article/details/109646278
     * 1.首先执行count=count （count=0）JVM会把count放到临时变量区
     * 2.再执行count++
     * 3.当++执行完了之后，jvm就会把在临时变量区的count放回来，但是这个时候count还是0
     */
    public static void test1(){
        int count = 0;
        for (int i=0; i< 100; i++){
            count = count ++;
        }
        System.out.println(count);
    }
}
