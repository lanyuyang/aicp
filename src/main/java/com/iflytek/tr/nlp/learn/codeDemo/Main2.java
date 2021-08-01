package com.iflytek.tr.nlp.learn.codeDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警呈现fiberid
 */
public class Main2 {
    static List<Integer> listBranch = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);


        listBranch.add(10);
        listBranch.add(11);
        listBranch.add(12);listBranch.add(13);
        listBranch.add(14);
        listBranch.add(15);

        filter(list);
    }
    static int index=8;
    static int tempIndex = 0;
    private static void filter(List<Integer> list){
        while (!isMuilt(list.get(index))){
            int num = list.get(index);
            System.out.println(num);
            if (num == 5){
                tempIndex = 5;
            }
            index --;
            if (index < 0){
                listBranch.clear();
                break;
            }
        }
        if (tempIndex != 0 && listBranch.size() != 0){
            index = tempIndex;
            filter(listBranch);
        }
    }
    private static boolean isMuilt(int n){
        if (n==0){
            return true;
        }
        return false;
    }
}
