package com.Solution.Tree;

//题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//思路：后序遍历思想
public class ISBalanced_Solution {
    private boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return false;
        Deepth(root);
        return flag;
    }

    private int Deepth(TreeNode node) {
        if (node == null)
            return 0;
        int ld = Deepth(node.left);
        int rd = Deepth(node.right);
        if (Math.abs(ld - rd) > 1)
            flag = false;
        return ld > rd ? ld + 1 : rd + 1;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        boolean ans=new ISBalanced_Solution().IsBalanced_Solution(root);
        System.out.println(ans);
    }
}
