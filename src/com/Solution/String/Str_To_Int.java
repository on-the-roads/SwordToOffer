package com.Solution.String;

/*
题目：将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
//思路：首先判断第一个字符是不是符号位，用flag做标记；是符号位，从第二位开始遍历字符串，否则从第一位开始遍历，遇到不是‘0’到‘9’的字符直接返回0。
public class Str_To_Int {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int flag = 1;
        long ans = 0;
        int i = 0;
        char first = str.charAt(0);

        if (first == '-') {
            flag = -1;
            i = 1;
        } else if (first == '+') {
            flag = 1;
            i = 1;
        } else if (first > '9' || first < '0')
            return 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0')
                return 0;
            int t = str.charAt(i) - '0';
            ans = ans * 10 + t;
        }
        return flag > 0 ? (int) ans : (int) -ans;
    }

    public static void main(String[] args) {
        int res = new Str_To_Int().StrToInt("+2147483647");
        int res1 = new Str_To_Int().StrToInt("1a33");
        int res2 = new Str_To_Int().StrToInt("-33");
    }
}
