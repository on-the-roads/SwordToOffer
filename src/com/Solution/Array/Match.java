package com.Solution.Array;

//题目：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
/*
思路：
当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位。
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }

    public boolean matchCore(char[] str, int sindex, int pindex, char[] pattern) {
        if (sindex >= str.length && pindex == pattern.length)
            return true;
        if (pindex >= pattern.length && sindex < str.length)
            return false;
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            if (sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.')) {
                return matchCore(str, sindex, pindex + 2, pattern) ||
                        matchCore(str, sindex + 1, pindex + 2, pattern) ||
                        matchCore(str, sindex + 1, pindex, pattern);
            } else {
                return matchCore(str, sindex, pindex + 2, pattern);
            }
        }
        if (sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex + 1, pindex + 1, pattern);
        return false;
    }

    public static void main(String[] args) {
        char[] pattern1 = {'a', '.', 'a'};
        char[] pattern2 = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] pattern3 = {'a', 'a', '.', 'a'};
        char[] pattern4 = {'a', 'b', '*', 'a'};
        char[] str1 = {'a', 'a', 'a'};
        boolean flag4 = new Match().match(str1, pattern4);
        boolean flag3 = new Match().match(str1, pattern3);
        boolean flag2 = new Match().match(str1, pattern2);
        boolean flag1 = new Match().match(str1, pattern1);
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
    }
}
