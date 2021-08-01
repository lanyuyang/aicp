package com.iflytek.tr.nlp.learn.niuke.lianxi;

/**
 * 进制转换专题
 *
 * 进制自定义类型转换
 */
public class Jinzhi {
    //设置字符数组
    //可以添加任意不重复字符，提高能转换的进制的上限
    static char chs[] = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    public static void main(String[] args) {
        // 将数字10 的10进制转换成2进制
        System.out.println(transRadix("10", 10, 2));
        // 将数字13 的10进制转换成16进制
        System.out.println(transRadix("13", 10, 16));

        // 将数字28 的10进制转换成26进制
        System.out.println(transRadix("28", 10, 26));
    }
    /**
     * 转换方法
     * @param num		元数据字符串
     * @param fromRadix	元数据的进制类型
     * @param toRadix	目标进制类型
     * @return
     */
    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(chs[number%toRadix]);
            number = number / toRadix;
        }
        return sb.reverse().toString();
    }
}
