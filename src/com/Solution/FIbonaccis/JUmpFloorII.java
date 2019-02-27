package com.Solution.FIbonaccis;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

public class JUmpFloorII {
    public int JumpFloorII(int target) {
        int ans=1;
        if(target<0)
            throw new RuntimeException("台阶数不能为负数");
      else {
            for (int i = 0; i <target-1 ; i++) {
                ans=ans<<1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        JUmpFloorII s=new JUmpFloorII();
        System.out.println(s.JumpFloorII(0));
        System.out.println(s.JumpFloorII(1));
        System.out.println(s.JumpFloorII(2));
        System.out.println(s.JumpFloorII(3));
//        System.out.println(s.JumpFloor(-1));
    }
}
