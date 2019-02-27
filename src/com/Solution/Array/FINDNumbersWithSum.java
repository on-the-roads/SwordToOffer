package com.Solution.Array;

import java.util.ArrayList;

/*
题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
//思路：左右夹逼，最初设置两个指针分别指向数组首元素和尾元素，根据它们的和与S作比较来单步移动两个指针。这样也能保证输出的两个数乘积是最小的。
public class FINDNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2)
            return list;
        int s = 0;
        int e = array.length - 1;
        int temp;
        while (s < e) {
            temp = array[s] + array[e];
            if (temp == sum) {
                list.add(array[s]);
                list.add(array[e]);
                break;
            } else if (temp > sum)
                e--;
            else
                s++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 6, 7, 10};
        int[] test1 = {1, 2, 4, 7, 11, 16};
        new FINDNumbersWithSum().FindNumbersWithSum(test, 10);
    }
}
