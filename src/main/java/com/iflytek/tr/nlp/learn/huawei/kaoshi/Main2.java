package com.iflytek.tr.nlp.learn.huawei.kaoshi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yylan on 2021/2/23.
 */
public class Main2 {
    static int L, S, T, M;
    static int stones[] = new int[110];
    static int f[] = new int[10020];
    static int w[] = new int[10020];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        S = sc.nextInt();
        T = sc.nextInt();
        M = sc.nextInt();

        for (int i= 1; i<= M ;i++){
            stones[i] = sc.nextInt();
        }
        sc.close();
        if (S == T){
            int res = 0;
            for (int i= 1; i<= M ;i++)
                if (stones[i] % S == 0)
                    res ++;
            System.out.println(res);
        }else {
            Arrays.sort(stones, 0, M+1);
            int last = 0, k=0;
            for (int i=1; i<= M ; i++){
                for (int j=1; j<= Math.min(stones[i] - last, 100); j++)
                    w[++k] = 0;
                w[k] = 1;
                last = stones[i];
            }
            for (int i=1; i<= k+10; i++){
                f[i] = 110000;
                for (int j=S; j<=T; j++)
                    if (i-j >= 0)
                        f[i] = Math.min(f[i], f[i-j] + w[i]);
            }
            int res = 110000;
            for ( int i=k;i<= k+10; i++)
                res = Math.min(res, f[i]);
            System.out.println(res);
        }
    }
}
