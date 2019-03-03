package com.Solution.Others;
//题目: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
//思路：用异或运算做不进位的加法，用与运算再左移一位来保存进位。
public class ADD {
    public int Add(int num1,int num2) {
        int t1;
        int t2;
        do {
            t1 = num1 ^ num2;//加法不进位
            t2 = (num1 & num2) << 1;//与运算再左移保存进位
            num1=t1;
            num2=t2;
        }while (t2!=0);
        return t1;
    }

    public static void main(String[] args) {
        int ans=new ADD().Add(1,2);
        System.out.println(ans);
    }
}
