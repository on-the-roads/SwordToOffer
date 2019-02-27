package com.Solution.Array;

import java.util.Vector;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：开辟空间，利用vector
 */
public class REOrderArray {
    public void reOrderArray(int [] array) {
        if(array==null)
            return;
        Vector<Integer> odd=new Vector<>();
        Vector<Integer> even=new Vector<>();
        for (int i = 0; i <array.length ; i++) {
            if(array[i]%2==0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }
        odd.addAll(even);
        for (int i = 0; i <array.length ; i++) {
          array[i]=odd.get(i);
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        new REOrderArray().reOrderArray(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
