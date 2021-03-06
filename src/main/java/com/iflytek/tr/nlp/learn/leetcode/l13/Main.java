package com.iflytek.tr.nlp.learn.leetcode.l13;//package com.iflytek.demo.leetcode.l13;

import java.util.*;

//
import javax.validation.constraints.Null;
import java.util.*;

/**
 *  13: 罗马数字转换
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 罗马数字转整数int
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        romanToInt(src);
    }
    public static int romanToInt(String s) {
        Map<String, Integer> dictMap = new HashMap<String, Integer>(){};
        dictMap.put("I",1);
        dictMap.put("V", 5);
        dictMap.put("X", 10);
        dictMap.put("L", 50);
        dictMap.put("C", 100);
        dictMap.put("D", 500);
        dictMap.put("M", 1000);
        dictMap.put("IV", 4);
        dictMap.put("IX", 9);
        dictMap.put("XL", 40);
        dictMap.put("XC", 90);
        dictMap.put("CD", 400);
        dictMap.put("CM", 900);
        List<String> lists = new ArrayList<String>(){};
        lists.add("IV");
        lists.add("IX");
        lists.add("XL");
        lists.add("XC");
        lists.add("CD");
        lists.add("CM");
        s = s.replaceAll("\"","");
        int sum = 0;
        // 1 校验字符串
        if (checkStr(s)){
            // 1、找出特殊情况，
            for (String st : lists){
                if (s.contains(st)){
                    sum += dictMap.get(st);
                    s = s.replaceFirst(st, "");
                }
            }
            // 2、循环相加
            for (int i=0; i< s.length(); i++){
                char c = s.charAt(i);
                sum += dictMap.get(String.valueOf(c));
            }
        }
        return sum;
    }
    public static boolean checkStr(String str){
        if (str.length() == 0 && str.length() > 15){
            return false;
        }
        String regx = "^[IVXLCDM]+$";
        if (!str.matches(regx)){
            return false;
        }
        return true;
    }
}
