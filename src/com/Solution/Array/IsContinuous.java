package com.Solution.Array;

import java.util.Arrays;

//题目：共有54张扑克牌，其中两张大王，两张小王，它们可以看成任意数字，从中抽取5张牌，判断并输出是不是顺子。
//思路：先对数组进行排序，然后判断0的个数和非0数的空缺（前后两数的差减去1）的个数，如果0的个数大于等于空缺数，则说明数组是“顺子“，同时
//注意到数组中除了0之外不能有“对子”出现，有“对子”则一定不为“顺子”。
public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5)
            return false;
        Arrays.sort(numbers);
        int numof0 = 0;
        int count_blank = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0)
                numof0++;
            else {
                int n = numbers[i + 1] - numbers[i] - 1;
                if (n == -1)//判断数组中除了0 以外，是否有其他相同的两个数。
                    return false;
                count_blank += n;
            }
        }
        if (numof0 >= count_blank)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] test = {0, 2, 4, 5, 6};
        int[] test1 = {2, 3, 4, 5, 6};
        int[] test2 = {0, 0, 4, 5, 6};
        int[] test3 = {0, 0, 4, 6, 7};
        int[] test4 = {1, 2, 4, 6, 7};

        boolean ans = new IsContinuous().isContinuous(test);
        boolean ans1 = new IsContinuous().isContinuous(test1);
        boolean ans2 = new IsContinuous().isContinuous(test2);
        boolean ans3 = new IsContinuous().isContinuous(test3);
        boolean ans4 = new IsContinuous().isContinuous(test4);
    }
}
