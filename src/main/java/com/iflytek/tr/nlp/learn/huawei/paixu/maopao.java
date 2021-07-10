package com.iflytek.tr.nlp.learn.huawei.paixu;

/**
 * Created by yylan on 2021/3/2.
 */
public class maopao {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 2, 4};
       for (int i=0; i< arr.length; i++){
           for (int j=0; j< arr.length -i -1; j++){
               if (arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}
