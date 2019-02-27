package com.Solution.Array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PRintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int colbegin = 0;
        int colend = col - 1;
        int rowbegin = 0;
        int rowend = row - 1;
        while (colbegin <= colend && rowbegin <= rowend) {
/*            //防止单行情况
            if(colbegin==colend){
                for (int i = rowbegin; i <=rowend; i++) {
                    list.add(matrix[i][colbegin]);
                }
                return list;
            }
            //防止单列情况
            else if(rowbegin==rowend){
                for (int j = colbegin; j <=colend ; j++) {
                    list.add(matrix[rowbegin][j]);
                }
                return list;
            }
        */
//else{
                 //向右
                for (int j = colbegin; j <= colend; j++) {
                    list.add(matrix[rowbegin][j]);
                }
                //向下
                for (int i = rowbegin + 1; i <= rowend; i++) {
                    list.add(matrix[i][colend]);
                }
                //向左
                if (rowbegin != rowend)
                    for (int j = colend - 1; j >= colbegin; j--) {
                        list.add(matrix[rowend][j]);
                    }
                //向上
                if (colbegin != colend)
                    for (int i = rowend - 1; i >= rowbegin + 1; i--) {
                        list.add(matrix[i][colbegin]);
                    }
//            }

                colbegin++;
                rowbegin++;
                colend--;
                rowend--;
            }
            return list;
        }

        public static void main (String[]args){
            int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
            int[][] matrix2 = {{1}, {2}, {3}, {4}, {5}};
            int[][] matrix3 = {{1, 2, 3, 4, 5}};
            int[][] matrix4 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
            int[][] matrix5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            PRintMatrix p = new PRintMatrix();
//        ArrayList<Integer> list=p.printMatrix(matrix1);
            ArrayList<Integer> list = p.printMatrix(matrix4);
            for (Integer i : list)
                System.out.print(i + " ");

        }
    }
