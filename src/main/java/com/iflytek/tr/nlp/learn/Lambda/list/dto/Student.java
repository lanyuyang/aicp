package com.iflytek.tr.nlp.learn.Lambda.list.dto;

import lombok.Data;

@Data
public class Student {
    private int age;
    private String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }
}
