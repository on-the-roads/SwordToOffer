package com.Solution.Array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：遍历循环
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return  0;

        for (int i = 0; i < array.length-1; i++) {
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] a={3,4,5,1,2};
        int[] b={10};
//        int result=new MinNumberInRotateArray().minNumberInRotateArray(a);
        int result=new MinNumberInRotateArray().minNumberInRotateArray(b);
        System.out.println(result);
    }
}