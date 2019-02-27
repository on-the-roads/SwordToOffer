package com.Solution.WeiAlgorithm;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：将一个数与该数减去1的结果相与，该数从右边数第一个1变为0，其余位数不变。
 */
public class NUMberOf1 {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0)
        {
            count++;
            n=(n-1)&n;
        }
        return  count;
    }

    public static void main(String[] args) {
        NUMberOf1 s=new NUMberOf1();
        System.out.println(s.NumberOf1(15));
    }
}
