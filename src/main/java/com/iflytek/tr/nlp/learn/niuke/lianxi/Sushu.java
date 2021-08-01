package com.iflytek.tr.nlp.learn.niuke.lianxi;

/**
 * 素数专题
 *
 */
public class Sushu {
    public static void main(String[] args) {

    }
    // 判断是否是素数
    public static boolean isPrime(int num){//判断是否是素数
        boolean flag = true;
        if (num < 2) {// 负数，0,1都不是素数，不用判断
            return false;
        }else{
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {// 若能被整除，则说明不是素数
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
