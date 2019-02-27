package com.Solution.Tree;

import java.util.LinkedList;
import java.util.Queue;

//题目：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
/*
   思路1：利用后序遍历的思想
   思路2：利用层序遍历思想
 */
public class Tree_Depth {

    public int TreeDepth(TreeNode root) {
//        //后序遍历思想
//        int h = 0;
//        int leftH = 0;
//        int rightH = 0;
//
//        if (root == null)
//            return 0;
//        leftH = TreeDepth(root.left);
//        rightH = TreeDepth(root.right);
//        h=leftH>rightH?leftH:rightH;
//        return  h+1;
     //层序遍历思想：利用队列实现层序遍历
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode node=root;
        queue.add(node);
        int start=0;
        int end=1;
        int deep=0;
        while(!queue.isEmpty())
        {
            node=queue.poll();
            start++;
            if(node.left!=null)
                ((LinkedList<TreeNode>) queue).add(node.left);
            if(node.right!=null)
                queue.add(node.right);
            if(start==end)
            {
                end=queue.size();
                start=0;
                deep++;
            }
        }
        return deep;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        int h=new Tree_Depth().TreeDepth(root);
        System.out.println(h);
    }
}
