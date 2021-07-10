package com.iflytek.tr.nlp.learn.huawei;

/**
 * Created by yylan on 2021/2/22.
 * 简单正则表达式匹配的Java实现
 * LeetCode的Problem 10 (Regular Expression Matching)是一道简单版本的正则表达式匹配问题。题中的匹配符号只有两种，分别是"."和"*"，前者可以匹配任意单个字符。后者在使用时需要保证符号前有字符或"."存在，匹配0个或多个字符。即a*匹配0个或多个连续的a，.*代表任意个"."，因此匹配所有的字符串。题目要求输入目的字符串s以及匹配字符串p，输出匹配结果，即是否可以成功匹配。

 对于该问题，可以使用动态规划来编写算法。

 首先定义二维状态数组f以存放每个匹配阶段的状态，f[i][j]表示匹配字符串p从0到j-1的子串匹配目的字符串s从0到i-1的子串的匹配结果。根据输入的目的字符串s和匹配字符串p可以分别得到其大小，令其为m与n。根据m与n的大小可以定义二维状态数组f[m+1][n+1]。

 其次进行数组的初始化过程。先将f[0][0]这个最初的状态设置为true，代表空串匹配空串，成功。然后通过循环将数组的第一列初始化为false，即f[i][0] = false，代表用空串匹配目的字符串，失败。紧接着需要初始化第一行。第一行代表目的字符串为空串，因此需要考虑到如a*的匹配结果。f[0][1]，匹配字符串为一个字符，显然无法与空串匹配，因此为false。第一行剩下的部分则开始判断是否为a*的情况，需要匹配字符串最后一个字符为"*"，且"a*"之前的匹配结果为成功才为true。即f[0][j] = p[j-1] == '*' && f[0][j-2];

 初始化之后，开始填充剩下的数组。通过一个两层的循环逐行逐个更新状态。

 对于每一次循环时，需要判断匹配字符串p当前的字符p[j-1]是否为"*"。若否，则只需判断当前的字符是否与s[i-1]相等，以及前面的部分是否匹配成功。若都为true，则f[i][j] = true；否则为false；

 若p[j-1]为"*"，对于"a*"，则需要将匹配的情况分成0个a与多个a两种情况分别讨论。f[i][j-2]代表匹配0个a的结果。(s[i-1] == p[j-2] || p[j-2] == '.') && f[i-1][j]代表匹配多个a的结果。

 循环之后便生成了所需的二维状态数组，其中f[m][n]即为所求的匹配结果
 */
public class Test4 {
    public static void main(String[] args) {

    }
    public static boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i=1;i<=m;i++){
            f[i][0] = false;
        }
        if(n != 0){
            f[0][1] = false;
        }
        for(int j=2;j<=n;j++){
            f[0][j] = pp[j-1] == '*' && f[0][j-2];
        }
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(pp[j-1] != '*'){
                    f[i][j] = f[i-1][j-1] && (pp[j-1] == ss[i-1] || pp[j-1] == '.');
                }else{
                    f[i][j] = f[i][j-2] || (ss[i-1] == pp[j-2] || pp[j-2] == '.') && f[i-1][j];
                }
            }
        return f[m][n];
    }
}
