package com.Solution.Array;

import java.util.HashMap;

/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
/*
    思路1：若允许开辟额外的空间，利用数组或者HashMap存储每个数字出现的次数
    思路2：不允许开辟空间，因为数组长度为n,所有数字范围都在0-n-1，所以当数组中没有重复的数字时，排序后第i位的数字为i。所以我们对数组进行
    重排，从头开始扫描数组，当第i位的数为i时，继续扫描下一位；否则，记当前数字为m,判断m与第m位数字是否相等，若相等，则找到重复数字，否则将第i位数字
    和第m位数字调换位置，继续循环。若直到最后都没有找到，返回false。
 */
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
//    public boolean duplicate(int numbers[], int length, int[] duplication) {
//        //思路1
//        if (numbers == null || length == 0)
//            return false;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            if (map.get(numbers[i]) == null)
//                map.put(numbers[i], 1);
//            else {
//                int value = map.get(numbers[i]);
//                map.put(numbers[i], value + 1);
//            }
//        }
//        for (int j = 0; j < length; j++) {
//            if (map.get(numbers[j]) == 2) {
//                duplication[0] = numbers[j];
//                return true;
//            }
//        }
//        return false;
//    }


    public boolean duplicate(int numbers[], int length, int[] duplication) {
        //思路2
        if (numbers == null || length == 0)
            return false;
        int i = 0;
        int m = 0;
        int temp=0;
        while (i < length) {
            m = numbers[i];
            if (m == i)
                i++;
            else if (m == numbers[m]) {
                duplication[0] = m;
                return true;
            }
            else {
                temp = numbers[m];
                numbers[m] = m;
                numbers[i] = temp;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {2,4,3,1,4};
        int[] duplicated = new int[1];
        boolean ans = new Duplicate().duplicate(test, test.length, duplicated);
    }
}
