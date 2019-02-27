package com.Solution.FIbonaccis;

/**
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 递归方法，不推荐，时间复杂度以指数级增长
 */
public class FIbonacci {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        FIbonacci s=new FIbonacci();
        System.out.println(s.Fibonacci(7));
    }
}