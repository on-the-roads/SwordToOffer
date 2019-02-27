package com.Solution.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 复杂度O（n^2),不推荐
 */
public class MoREThanHalfNum_Solution1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0)
            return 0;
        int len=array.length;
        int max=1;
        if(len==1)
            return array[0];
        for (int i = 0; i <=len-2 ; i++) {
                int num=1;
            for (int j = i+1; j <=len-1 ; j++) {
                if(array[i]==array[j])
                      num++;
            }
            max=max<num?num:max;
            if(max>len/2)
                return array[i];
        }
       return  0;
    }

    public static void main(String[] args) {
        int[] test={1,2,3,2,2,2,5,4,2};
        int[] test1={1};
        int ans=new MoREThanHalfNum_Solution1().MoreThanHalfNum_Solution(test1);
        System.out.println(ans);
    }
}
