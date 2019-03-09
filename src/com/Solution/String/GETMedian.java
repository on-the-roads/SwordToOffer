package com.Solution.String;

import java.util.ArrayList;
import java.util.Collections;
/*
 题目:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
/*
 思路：
 1.最容易想到：用数组实现
 2.用堆来实现
 */
public class GETMedian {
   ArrayList<Double> list=new ArrayList<>();
    public void Insert(Integer num) {
        list.add(Double.valueOf(num));
    }

    public Double GetMedian() {
        int size=list.size();
        double ans=0;
        if(size==0)
            return null;
        Collections.sort(list);
        if(size%2==0) {
            ans = (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
            return ans;
        }
        ans=list.get((size-1)/2);
        return  ans;
    }

    public static void main(String[] args) {
        GETMedian test=new GETMedian();
        test.Insert(2);
        test.Insert(5);
        test.Insert(3);
        System.out.println(test.GetMedian());
    }
}
