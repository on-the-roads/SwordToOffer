package com.Solution.Array;

import java.util.ArrayList;
//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序、*、
/*
思路：初始时设置两个初值是s和e，分别为1和2,判断从s到e的连续和sums与sum的大小，若sums<sum，则e++;sums>sum,s--;
将s<(sum+1)/2作为终止条件。
 */
public class FINDContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> List = new ArrayList<>();
        ArrayList<Integer> list ;
        if(sum<3)
            return List;
        int s=1;
        int e=2;
        int sums=s+e;
        while (s<=(sum+1)/2)
        {
            if(sums==sum)
            {
                list=new ArrayList<>();
                for (int i = s; i <=e ; i++) {
                    list.add(i);
                }
                List.add(list);
                e++;
                sums=sums+e;
            }
            else if(sums<sum)
            {
                e++;
                sums=sums+e;
            }
            else{
                sums=sums-s;
                s++;
            }
        }
        return List;
    }

    public static void main(String[] args) {
        new FINDContinuousSequence().FindContinuousSequence(100);
    }
}
