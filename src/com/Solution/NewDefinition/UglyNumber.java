package com.Solution.NewDefinition;


/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：空间换时间，建立数组按从小到大顺序保存丑数，新的丑数是前面丑数x2、x3、x5得到的，所以只用判断丑数.
 * 时间复杂度为O(n)
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
        return 0;
        int[] array=new int[index];//新建数组，按顺序存放丑数
        array[0]=1;
        int nextUglynumindex=1;
        int n2=0,n3=0,n5=0;
        int Uglyx2=array[n2];
        int Uglyx3=array[n3];
        int Uglyx5=array[n5];

        while(nextUglynumindex<index)
        {
            while(Uglyx2*2<=array[nextUglynumindex-1]){
                Uglyx2=array[n2++];
            } while(Uglyx3*3<=array[nextUglynumindex-1]){
                Uglyx3=array[n3++];
            } while(Uglyx5*5<=array[nextUglynumindex-1]){
                Uglyx5=array[n5++];
            }
            int temp1=Uglyx2*2;
            int temp2=Uglyx3*3;
            int temp3=Uglyx5*5;
            array[nextUglynumindex]=MIN(temp2,temp3,temp1);
            nextUglynumindex++;
        }
        int ans=array[index-1];
        array=null;
        return ans;
    }

    private int MIN(int uglyx2, int uglyx3, int uglyx5) {
        int ans=0;
        ans=uglyx2<uglyx3?uglyx2:uglyx3;
        ans=ans<uglyx5?ans:uglyx5;

        return  ans;
    }

    public static void main(String[] args) {


            System.out.print(new UglyNumber().GetUglyNumber_Solution(11)+" ");

    }

}
