package com.iflytek.tr.nlp.learn.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yylan on 2021/2/22.
 * 小兔子繁殖
 */
public class Test10 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);

//经过passMonth个月后（有几只兔子）
        int passMonth = 5;
// 从第一个月开始
        int month = 1;
// 建立一个兔子夫妻的集合
        ArrayList<Integer> rabbits = new ArrayList<Integer>();
// 兔子从第一个月开始计算
        int originCoupleRabbitAge = 1;
// 装入初生的那对兔子
        rabbits.add(originCoupleRabbitAge);
// 经过passMonth个月后有几只兔子
        while (month <= passMonth) {
            int rabbitsBeforeSize = rabbits.size();
// 遍历兔子集合
            for (int i = 0; i < rabbitsBeforeSize; i++) {
// 如果兔子达到第三个月或大于第三个月,生一对兔子放入集合中
                if (rabbits.get(i) >= 3) {
                    int newRabbit = 1;
                    rabbits.add(newRabbit);
                }
            }
// 每个兔子加一个月为了下一次计算
            for (int j = 0; j < rabbits.size(); j++) {
                int age = rabbits.get(j);
                age++;
                rabbits.set(j, age);
            }
// 时间过了一个月
            month++;
        }
        System.out.println("一共有:" + rabbits.size() + "对兔子");
    }
}
