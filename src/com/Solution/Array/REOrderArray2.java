package com.Solution.Array;

import java.util.Vector;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路：不能开辟空间，在数组内部进行交换，利用冒泡排序思路，将奇数换到前面
 */
public class REOrderArray2 {
    public void reOrderArray(int [] array) {
        if(array==null)
            return;
        int flag=0;
        int len=array.length;
        for (int i = len-1; i>1;i--) {
            for (int j = 0; j <i ; j++) {
                if(array[j]%2==0&&array[j+1]%2==1){
                    int temp=array[j];
                     array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0)
                return;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        new REOrderArray2().reOrderArray(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
