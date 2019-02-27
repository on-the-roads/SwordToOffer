package com.Solution.FIbonaccis;

/**
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * For循环方法，推荐，时间复杂度O（n）
 */
public class FIbonacci2 {
    public int Fibonacci(int n) {
        int[] a = {0, 1};
        int result=0;
        int firstnum=0;
        int secondnum=1;
        if (n < 0)
            throw new RuntimeException("请输入非负整数！");
        else if (n < 2)
            return a[n];

        for(int i=1;i<n;i++)
        {
            result=firstnum+secondnum;
            firstnum=secondnum;
            secondnum=result;
        }
        return  result;
    }

    public static void main(String[] args) {
        FIbonacci2 s = new FIbonacci2();
        System.out.println(s.Fibonacci(7));
    }
}