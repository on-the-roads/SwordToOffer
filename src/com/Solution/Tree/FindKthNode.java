package com.Solution.Tree;

import java.util.ArrayList;

public class FindKthNode {
    int index=0;
    TreeNode node=null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<1)
            return null;
        PostTraversal(pRoot,k);
        return  node;
    }
    private void PostTraversal(TreeNode root,int k)
    {
        if(root!=null)
        {
            PostTraversal(root.left,k);
            index++;
            if(index==k)
                node=root;
            PostTraversal(root.right,k);
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.right = new TreeNode(6);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(4);
        A.right.right = new TreeNode(7);
        TreeNode ans=new FindKthNode().KthNode(A,3);
    }
}
