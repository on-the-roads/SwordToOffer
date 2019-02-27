package com.Solution.Array;

//题目：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

import java.util.HashMap;
import java.util.Map;

/*
    思路1:利用异或的特点：”两个相等的数异或为0，不等为1“将数组拆分为两个子数组，子数组中分别只含有一个出现了单次的数字。
    这样对子数组就可以进行异或运算找出只出现一次的数字。

    思路2：利用hashmap,key存放数组的数组，value存放出现次数
 */
public class FINDNumsAppearOnce {
//    //思路1：
//    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
//        if (array == null || array.length < 4)
//            return;
//        int Xor = 0;
//        for (int i = 0; i < array.length; i++) {
//            Xor = Xor ^ array[i];
//        }
//        int index = FindFirst1FromRight(Xor);
//        int n1=0;
//        int n2=0;
//        for (int i = 0; i < array.length; i++) {
//            if(IsBit1(array[i],index)==1)
//                n2=n2^array[i];
//            else
//                n1=n1^array[i];
//        }
//        num1[0]=n1;
//        num2[0]=n2;
//    }
//private int IsBit1(int t, int num)
//{
//    for (int i = 0; i < num; i++) {
//              t=t>>1;
//    }
//
//    return  t&1;
//}
//
//    private int FindFirst1FromRight(int xor) {
//        int index = 0;
//        int n;
//        while (index < 8) {
//            n=1&xor;
//            if (n != 1) {
//                xor=xor>>1;
//                index++;
//            }
//            else
//                break;
//        }
//        return index;
//    }

    //思路2:
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if(array==null||array.length<4)
            return;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.get(array[i])==null)
                map.put(array[i],1);
            else{
                int value=map.get(array[i]);
                map.put(array[i],value+1);
            }
        }
        int[] temp=new int[3];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
                temp[i++]=entry.getKey();
        }
        num1[0]=temp[0];
        num2[0]=temp[1];
    }
    public static void main(String[] args) {
        int[] test={2,4,3,6,3,2,5,5};
        int[] num1={0};
        int[] num2={0};
        new FINDNumsAppearOnce().FindNumsAppearOnce(test,num1,num2);
    }
}
