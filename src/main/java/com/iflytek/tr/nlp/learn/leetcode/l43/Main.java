package com.iflytek.tr.nlp.learn.leetcode.l43;

/**
 * 43 字符相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {

        int n = num1.length(), m = num2.length();
        int[] A = new int[n], B = new int[m];
        for (int i = n - 1; i >= 0; i--) A[n - 1 - i] = num1.charAt(i) - '0';
        for (int i = m - 1; i >= 0; i--) B[m - 1 - i] = num2.charAt(i) - '0';

        int[] C = new int[n + m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i + j] += A[i] * B[j];
        int t = 0;
        for (int i = 0; i < C.length; i++) {
            t += C[i];
            C[i] = t % 10;
            t /= 10;
        }
        int k = C.length - 1;
        while (k > 0 && C[k] == 0) k--;
        StringBuilder sb = new StringBuilder();
        while (k >= 0) sb.append((char)(C[k--] + '0'));
        return sb.toString();
    }
}
/**
 * 思路：
 *普通竖式
 *
 * 以num1 = 123 , num2 = 456为例：我们遍历 num2 每一位与 num1 进行相乘，将每一步的结果进行累加，在这个过程如果相乘或者相加的结果大于等于10 ，我们都要去满10进位，
 *
*   其实在相乘或者相加计算过程的每一位，我们可以考虑先不去满10进位，等到计算完所有的相乘结果以后，最终将其加到一块，再去满10进位 ，最后的结果和普通竖式 一样，但却可以大大简化我们的模拟过程。(如下图所示)
 *
 */
