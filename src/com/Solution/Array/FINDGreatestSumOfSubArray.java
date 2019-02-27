package com.Solution.Array;


/**
 * 返回数组的最大连续子序列的和
 */
public class FINDGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int temp=0;
        int sum=Integer.MIN_VALUE;
        if(array==null||array.length==0)
            throw new RuntimeException("数组无元素");
        for (int i = 0; i < array.length; i++) {
            temp=temp+array[i];
            if(sum<temp)
                sum=temp;
            if(temp<0) {
                temp=0;
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int[] test={6,-3,-2,7,-15,1,2,2};
        int[] test1={1,-2,3,10,-4,7,2,-5};
        int[] test2={-1,-2,-3};
        int ans;
        ans=new FINDGreatestSumOfSubArray().FindGreatestSumOfSubArray(test);
        ans=new FINDGreatestSumOfSubArray().FindGreatestSumOfSubArray(test1);
//        ans=new FINDGreatestSumOfSubArray().FindGreatestSumOfSubArray(test2);
        System.out.println(ans);
    }
}
