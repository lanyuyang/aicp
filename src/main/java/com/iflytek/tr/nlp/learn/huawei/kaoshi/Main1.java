package com.iflytek.tr.nlp.learn.huawei.kaoshi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by yylan on 2021/2/23.
 */
public class Main1 {
    static HashMap<Long, Integer> stonel = new HashMap<Long, Integer>();
    static HashMap<Long, Integer> stoneP = new HashMap<Long, Integer>();
    static long l;
    static int s, t;
    static int m;
    static TreeMap<Long,Integer> tm = new TreeMap<Long, Integer>();
    static TreeSet<Long> ts = new TreeSet<Long>();
    static void jump (long formPoint, int formStone){
        for(int i=s; i< t+1 && formPoint <l; i++){
            long curPoint = formPoint +i;
            int curStone =formStone;
            if (stoneP.containsKey(curPoint)){
                curStone += 1;
            }
            if (!stonel.containsKey(curPoint)){
                stonel.put(curPoint, curStone);
                tm.put(curPoint, curStone);
            }else if (curStone < stonel.get(curPoint)){
                stonel.put(curPoint, curStone);
                tm.put(curPoint, curStone);
            }else {
                continue;
            }
        }

        while (!tm.isEmpty()){
            long pointStack = tm.firstKey();
            int stonStack = tm.get(pointStack);
            tm.remove(pointStack);
            jump(pointStack, stonStack);
        }

    }

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        l = Long.valueOf(br.readLine());

        l = 0;
        String str = br.readLine();
        String[] sstr = str.split(" ");
        s = Integer.valueOf(sstr[0]);
        t = Integer.valueOf(sstr[1]);
        m = Integer.valueOf(sstr[2]);

        str = br.readLine();
        sstr = str.split(" ");

        for (String ss : sstr){
            ts.add(Long.valueOf(ss));
        }
        if (s == t){
            int count =0;
            for (Long sto : ts){
                if (sto % s ==0 ){
                    count ++;
                }
            }
            System.out.println(count);
            return;
        }

        long yusto = 0;
        for (Long sto : ts){
            if (sto - yusto > 81){
                l += 81;
            }else {
                l = l+ sto - yusto;
            }
            stoneP.put(l,1);
            yusto = sto;
        }
        jump(0, 0);
        TreeMap<Long,Integer> tm2 = new TreeMap<Long, Integer>();
        for (long j=l; j< l+t; j++){
            if (stonel.containsKey(j)){
                tm2.put(j, stonel.get(j));
            }
        }
        System.out.println(tm2.get(tm2.firstKey()));
    }
}
