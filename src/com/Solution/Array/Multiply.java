package com.Solution.Array;

//题目：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
// 不能使用除法。
//思路1：最容易想到的解法，遍历，复杂度为Olog(n^2)
//思路2：构造方阵，行为B[i]，列为A[i],将B[i]的计算分为两步，先计算每个B[i]的下对角线部分，再计算上对角部分，时间复杂度为O（n）
public class Multiply {
//    public int[] multiply(int[] A) {
//    思路1
//        if (A == null || A.length == 0)
//            return null;
//        int[] m=new int[A.length];
//        for (int i = 0; i < m.length; i++) {
//            m[i] = 1;
//        }
//        for (int i = 0; i < m.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if (i != j)
//                    m[i] *= A[j];
//            }
//        }
//        return m;
//    }

    public int[] multiply(int[] A) {
//        思路2
        if(A==null||A.length==0)
            return A;
        int[] B=new int[A.length];
        B[0]=1;
        //对下对角线部分进行计算
        for (int i = 1; i <A.length ; i++) {
            B[i]=B[i-1]*A[i-1];
        }
        int temp=1;
        //对上对角线部分进行计算
        for (int i = A.length-2; i >=0 ; i--) {
            temp*=A[i+1];
            B[i]*=temp;
        }
        return  B;
    }



    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4};
        int[] ans = new Multiply().multiply(test);
    }
}
