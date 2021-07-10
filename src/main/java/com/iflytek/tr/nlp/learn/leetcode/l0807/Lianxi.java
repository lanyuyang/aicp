package com.iflytek.tr.nlp.learn.leetcode.l0807;

public class Lianxi {
    public static void main(String[] args) {

    }

    public static void permutation(char[] arr){

    }
    public static void dfs(char[] arr, int i, int n){
        for (int k=i; i<n; k++){
            swap(arr, i, k);
            dfs(arr, i+1, n);
            swap(arr, i, k);
        }
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
