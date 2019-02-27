package com.Solution.FIbonaccis;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：仍然是斐波那契数列
 */
public class REctCover {
    public int RectCover(int target) {
        int[] a = {0, 1};
        int result=0;
        int firstnum=1;
        int secondnum=1;
        if (target < 0)
            throw new RuntimeException("请输入非负整数！");
        else if (target < 2)
            return a[target];

        for(int i=1;i<target;i++)
        {
            result=firstnum+secondnum;
            firstnum=secondnum;
            secondnum=result;
        }
        return  result;
    }
}
