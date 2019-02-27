package com.Solution.Array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

//思路：从右上角或者左下角的元素开始和目标元素进行判断，这样就可以消去一行或者一列
public class Find {
    public boolean Find(int target, int[][] array) {
        boolean flag = false;
        int num = 0;
        if (array == null)
            return flag;
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            num = array[row][column];

            if (target < num)//所找元素小于右上角元素
            {
                column--;
            } else if (target > num) {
                row++;
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        int[][] testArray = new int[4][4];
        int[] r0 = {1, 2, 8, 9};
        int[] r1 = {2, 4, 9, 12};
        int[] r2 = {4, 7, 10, 13};
        int[] r3 = {6, 8, 11, 15};
        testArray[0] = r0;
        testArray[1] = r1;
        testArray[2] = r2;
        testArray[3] = r3;
//        for (int i = 0; i <3 ; i++) {
//            for (int j = 0; j <3 ; j++) {
//                testArray[i][j]=3*i+j;
//            }
//        }
        boolean ans = new Find().Find(7, testArray);
        System.out.println(ans);
    }
}
