package com.Solution.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 题目:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
/*
 思路：
 1.最容易想到：用数组实现,插入整数后，对数组进行排序
 2.用堆来实现：建立两个堆，一个最大堆位于左边，一个最小堆位于右边，保证最大堆的大小始终等于最小堆的大小或者比最小堆尺寸大1。
   插入元素时先插入后调整两个堆的大小。
 */
public class GETMedian {
    //思路1
//   ArrayList<Double> list=new ArrayList<>();
//    public void Insert(Integer num) {
//        list.add(Double.valueOf(num));
//    }
//
//    public Double GetMedian() {
//        int size=list.size();
//        double ans=0;
//        if(size==0)
//            return null;
//        Collections.sort(list);
//        if(size%2==0) {
//            ans = (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
//            return ans;
//        }
//        ans=list.get((size-1)/2);
//        return  ans;
//    }
//思路2
    //最大堆位于左边
    PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    );
    //最小堆位于右边
    PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    double ans;

    public void Insert(Integer num) {
        //先插入整数，后调整两个堆的大小
        if (q1.size() == 0 || num <= q1.peek())
            q1.add(num);
        else
            q2.add(num);
        if (q1.size() < q2.size())
            q1.add(q2.poll());
        else if (q1.size() - 2 == q2.size())
            q2.add(q1.poll());
    }

    public Double GetMedian() {
        if (q2.size() == 0)
            ans = q1.peek();
        else if ((q1.size() + q2.size()) % 2 == 0)
            ans = (double) (q1.peek() + q2.peek()) / 2;
        else
            ans = q1.peek();
        return ans;
    }

    public static void main(String[] args) {
        GETMedian test = new GETMedian();
        test.Insert(2);
        test.Insert(5);
        test.Insert(3);
        System.out.println(test.GetMedian());
    }
}
