package com.Solution.Tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VERIFYSquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
        return  VerifySquenceOfBST(sequence,0,sequence.length-1);

    }

    private boolean VerifySquenceOfBST(int [] sequence, int start,int end){
        if(start>=end)
            return true;
        int root=sequence[end];
        int i=0;


        //从右往左遍历找到第一个小于根的元素下标并作为分界点
        for(i=end-1;i>=start;i--)
        {
            if(sequence[i]<root) {
                break;
            }
        }

        //判断分界点左边元素是否都小于根
        for(int k=start;k<i;k++)
        {
            if(sequence[k]>root)
                return false;
        }
        //上述判断没有返回false则递归判断左子树和右字数
        boolean left=true;
        boolean right=true;
        //递归左子树
        left=VerifySquenceOfBST(sequence,start,i);
        //递归右子树
        right=VerifySquenceOfBST(sequence,i+1,end-1);

        return left&&right;
    }

    public static void main(String[] args) {
        int[] test={1,3,2};
        int[] test1={1,3,2,5,7,6,4};
        int[] test2={1,8,3,2,5,7,6,4};
        boolean ans=new VERIFYSquenceOfBST().VerifySquenceOfBST(test2);
        System.out.println(ans);
    }
}
