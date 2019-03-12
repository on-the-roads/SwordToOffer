package com.Solution.Array;

import java.util.ArrayList;

/**
 * 题目：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 * 思路1：用数组实现，每滑动一次窗口比较新加入的值是否大于之前的最大值
 *        (1)满足则进行最大值下标的替换；
 *        (2)不满足则判断丢失的值是否为之前的最大值，
 *              是则重新对当前窗口寻找最大值下标；
 *              不是则最大值下标不变，继续循环。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1)
            return list;
        int len = num.length;
        if (size > len) {
            return list;
        }
        int max = getMax(num, 0, size - 1);
        list.add(num[max]);
        for (int i = 0; i <= len - size - 1; i++) {
            if ((i + size) <= (len - 1) && num[i + size] >= num[max])
                max = i + size;
            else if (i + 1 > max)
                max = getMax(num, i + 1, i + size);
            list.add(num[max]);
        }
        return list;
    }

    private int getMax(int[] a, int s, int e) {
        int max = s;
        for (int i = s; i <= e; i++) {
            if (a[i] > a[max])
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] test = {2, 3, 4, 2, 6, 2, 5, 1};
        list = new MaxInWindows().maxInWindows(test, 3);
    }
}
