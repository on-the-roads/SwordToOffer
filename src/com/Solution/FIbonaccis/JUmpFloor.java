package com.Solution.FIbonaccis;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//本质上就是斐波那契数列。
public class JUmpFloor {
    public int JumpFloor(int target) {
        int ans=0;
        if(target<0)
            throw new RuntimeException("台阶数不能为负数");
        int[] first={0,1};
        int num1=1;
        int num2=1;
        if(target<2)
            return first[target];
        else {
            for (int i = 1; i <target ; i++) {
                ans=num1+num2;
                num1=num2;
                num2=ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        JUmpFloor s=new JUmpFloor();
        System.out.println(s.JumpFloor(0));
        System.out.println(s.JumpFloor(1));
        System.out.println(s.JumpFloor(2));
        System.out.println(s.JumpFloor(3));
//        System.out.println(s.JumpFloor(-1));
    }
}
