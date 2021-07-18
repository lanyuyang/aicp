package com.iflytek.tr.nlp.learn.niuke.lianxi;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        test2();
    }
    public static void test1(){
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
    public static void test2(){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", null);
        hashMap.put("name", "asd");
        System.out.println(hashMap.size());
    }
}
