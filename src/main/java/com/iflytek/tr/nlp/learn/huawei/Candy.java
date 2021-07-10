package com.iflytek.tr.nlp.learn.huawei;

/**
 * Created by yylan on 2021/2/22.
 * 分糖问题
 * Solo和koko是两兄弟，妈妈给了他们一大袋糖，每块糖上都有自己的重量。现在他们想要将这些糖分成两堆。分糖的任务当然落到了大哥Solo的身上，然而koko要求必须两个人获得的糖的总重量“相等”（根据Koko的逻辑），要不然就会哭的。
 非常不幸的是，koko还非常小，并且他只会先将两个数转成二进制再进行加法，而且总会忘记进位。如当12（1100）加
 */
import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int n = Integer.parseInt(in.nextLine().trim());
            int[] arr = new int[n];
            String[] ss = in.nextLine().trim().split(" ");
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(ss[i].trim());
            }
            String result = getResult(arr);
            System.out.println(result);
        }
    }

    private static String getResult(int[] arr) {
        if(arr.length == 0 || arr.length == 1 || (arr.length == 2 && arr[0] != arr[1]))
            return "NO";
        int min = arr[0];
        int sum = min;
        int temp = min;
        for(int i=1;i<arr.length;i++){
            sum += arr[i];
            min = min < arr[i] ? min : arr[i];
            temp ^= arr[i];
        }
        if(temp != 0){
            return "NO";
        }else{
            return String.valueOf(sum - min);
        }
    }
}