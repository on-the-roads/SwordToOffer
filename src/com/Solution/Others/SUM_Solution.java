package com.Solution.Others;

//题目： 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//思路：用“短路与”&&，当&&前面的判断条件不成立时，后面的语句不执行。
public class SUM_Solution {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean t=(n>0)&&(sum+=Sum_Solution(n-1))>0;
        return  sum;
    }

    public static void main(String[] args) {
        new SUM_Solution().Sum_Solution(5);
    }
}
