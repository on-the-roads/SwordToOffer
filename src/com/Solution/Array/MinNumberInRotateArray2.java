package com.Solution.Array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：二分法
 */
public class MinNumberInRotateArray2 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return  0;
        int sindex=0;
        int eindex=array.length-1;
        int mindex=sindex;
        if(array[sindex]<array[eindex])//当首元素小于末尾元素时说明初始顺序是非减的，直接返回首元素。
            return  array[mindex];
        while (sindex<eindex) {
            if(sindex+1==eindex){
                mindex=eindex;
                break;
            }
             mindex = (sindex + eindex) / 2;
            //如果sindex,eindex和mindex指向元素相等，则只能顺序查找。
            if(array[sindex]==array[eindex]&&array[sindex]==array[mindex]){
                mindex=minInorder(array,sindex,eindex);
                break;
            }
            else if (array[mindex] < array[eindex]) {
                eindex=mindex;
            }
            else
                sindex=mindex;
        }
        return  array[mindex];
    }

    public int minInorder(int[] arr,int begin,int end){
        int result=0;
        for (int i = begin; i <end ; i++) {
            if(arr[i]>arr[i+1]){
                result=i+1;
                break;
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        int[] a={3,4,5,1,2};
        int[] b={10};
        int[] c={1,1,1,0,1};
        int[] d={1,2,3,4,5};
        int[] e={1,1,1,1,1};
        int[] f={1,0,1,1,1,1};

//        int result=new MinNumberInRotateArray().minNumberInRotateArray(a);
//        int result=new MinNumberInRotateArray2().minNumberInRotateArray(b);
//        int result=new MinNumberInRotateArray2().minNumberInRotateArray(c);
//        int result=new MinNumberInRotateArray2().minNumberInRotateArray(d);
//        int result=new MinNumberInRotateArray2().minNumberInRotateArray(e);
        int result=new MinNumberInRotateArray2().minNumberInRotateArray(f);
        System.out.println(result);
    }
}