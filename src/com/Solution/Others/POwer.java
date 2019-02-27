package com.Solution.Others;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 思路：常规解法
 */
public class POwer {
    public double Power(double base, int exponent) {
        double ans = 0;
        if (base == 0 && exponent < 0)
            throw new RuntimeException("分母不能为0！");
        else if (exponent >= 0) {
            ans = 1;
            for (int i = 1; i <= exponent; i++) {
                ans = ans * base;
            }
            return ans;
        } else {
            exponent = -exponent;
            return 1 / Power(base, exponent);
        }
    }

    public static void main(String[] args) {
        POwer s=new POwer();
        System.out.println(s.Power(-2,-2));
        System.out.println(s.Power(0,-2));
        System.out.println(s.Power(2,-2));
        System.out.println(s.Power(2,2));
    }
}
