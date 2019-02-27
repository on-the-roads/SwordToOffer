package com.Solution.Others;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 思路：递归解法（推荐）
 */
public class POwer2 {
    public double Power(double base, int exponent) {
        double ans = 0;
        if (base == 0 && exponent < 0)
            throw new RuntimeException("分母不能为0！");
        else if (exponent >= 0) {
                ans=UnsignedPower(base,exponent);
                return  ans;
        } else {
            exponent = -exponent;
            return 1 / UnsignedPower(base, exponent);
        }
    }

    public double UnsignedPower(double a, int n){
        double result=1;
        if(n==0)
            return 1;
        if(n==1)
            return a;
        result=UnsignedPower(a,n>>1);//移位比除法效率更高
        result=result*result;
        if((n&0x1)==1)
            result=result*a;
        return  result;
    }

    public static void main(String[] args) {
        POwer2 s=new POwer2();
        System.out.println(s.Power(-2,-2));
        System.out.println(s.Power(2,-2));
        System.out.println(s.Power(2,2));
//        System.out.println(s.Power(0,-2));
    }
}
