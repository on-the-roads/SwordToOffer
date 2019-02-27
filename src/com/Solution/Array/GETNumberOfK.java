package com.Solution.Array;

//题目：统计一个数字在排序数组中出现的次数。
/*
  思路：正常思路是对数组进行遍历，时间复杂度为O(n)，因此我们应该更好的算法时间复杂度应该为O(logn)
  所以采用二分查找到k出现的第一个下标和最后一个下标，从而获得次数，时间复杂度为O(log n)
 */
public class GETNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int end = array.length - 1;
        int first = GetFirstK(array, 0, end,k);
        int last = GetLastK(array, 0, end,k);
        if(first>-1&&last>-1)
        return  last-first+1;
        else
            return 0;
    }

    private int GetFirstK(int[] array, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        int middata=array[mid];
        if(middata==k)
        {
            if((mid>0&&array[mid-1]!=middata)||mid==0)
                return mid;
            else
                end=mid-1;
        }
        else if(middata<k){
            start=mid+1;
        }
       else
            end=mid-1;

        return GetFirstK(array,start,end,k);
    }

    private int GetLastK(int[] array, int start, int end, int k) {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        int middata=array[mid];
        if(middata==k)
        {
            if((mid<(array.length-1)&&array[mid+1]!=middata)||mid==array.length-1)
                return  mid;
            else
                start=mid+1;
        }
        else if(middata<k){
            start=mid+1;
        }
        else
            end=mid-1;
        return GetLastK(array,start,end,k);
    }

    public static void main(String[] args) {
        int[] test1={0,2,3,3,4};
        int[] test2={0,2,3,4,4};
        int ans=new GETNumberOfK().GetNumberOfK(test2,1);
        System.out.println(ans);
    }
}
