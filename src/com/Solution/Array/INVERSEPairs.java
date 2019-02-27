package com.Solution.Array;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
/*
    思路：**空间换时间**
    将数组不断的拆分为长度为1的数组，利用归并排序合并相邻子数组，同时统计逆序对。
    考察：归并排序，时间复杂度为O（nlogn)
 */
public class INVERSEPairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0)
            return -1;
        return MergeSort(array, 0, array.length - 1);
    }

    private int MergeSort(int[] array, int start, int end) {
        if (start == end)
            return 0;
        int mid = (start + end) / 2;
        int left_count = MergeSort(array, start, mid);
        int right_count = MergeSort(array, mid + 1, end);
        int[] copy = new int[end - start + 1];
        int copy_index = end - start;
        int i = mid;
        int j = end;
        int num = 0;
        while (i >= start && j >= (mid + 1)) {
            if (array[i] >= array[j]) {
                copy[copy_index--] = array[i--];
                num = num + j - mid;
                if (num >= 1000000007)
                    num = num % 1000000007;
            } else
                copy[copy_index--] = array[j--];
        }
        while (i >= start)
            copy[copy_index--] = array[i--];
        while (j >= (mid + 1))
            copy[copy_index--] = array[j--];
        i = 0;
        while (start <= end)
            array[start++] = copy[i++];
        return (left_count + right_count + num) % 1000000007;
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 0};

        int ans = 0;
        ans = new INVERSEPairs().InversePairs(test);
        System.out.println(ans);
    }
}
