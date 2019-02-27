package com.Solution.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GETLeastNumbers_Solution {
    /**思路1：用最大堆来实现，这样获得最大元素的时间复杂度为O（1）,删除和插入的时间复杂度为O(log k)。创建一个大小为k的最大堆，
     * 遍历input[]数组元素，大于堆的最大元素则替代。
     * java中的优先队列是基于堆实现的
     * （思路2：利用Arrays的sort（）方法对数组进行排序，然后取前k个数，时间度为nlog(n) )
     * （思路3：利用红黑树来实现，查找，删除和插入的时间复杂度都为为O(log k) ），在java中用TreeSet
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k==0)
            return  list;
        PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i <input.length ; i++) {
            if(maxheap.size()!=k)
                maxheap.add(input[i]);
            else if(input[i]<maxheap.peek())
            {
                maxheap.poll();
                maxheap.add(input[i]);
            }
        }
        for(Integer i:maxheap)
            list.add(i);
        return  list;
    }

    public static void main(String[] args) {
        int[] test={4,5,1,6,2,7,3,8};
        ArrayList<Integer> list=new GETLeastNumbers_Solution().GetLeastNumbers_Solution(test,4);
        for(Integer i:list)
            System.out.print(i+" ");
    }
}
