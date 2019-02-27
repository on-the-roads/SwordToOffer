package com.Solution.Tree;

import java.util.concurrent.ArrayBlockingQueue;

public class MIrror {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);

    }
    public void swap(TreeNode node){
        if(node.left==null&&node.right==null)
            return;

        TreeNode temp=null;
        temp=node.left;
        node.left=node.right;
        node.right=temp;
    }

    //层序遍历
    public void LevelOrderTransversal(TreeNode root)
    {
        if(root==null)
            return;
        ArrayBlockingQueue<TreeNode> array=new ArrayBlockingQueue<>(30);
        TreeNode node=root;
        array.add(root);
        while (!array.isEmpty())
        {
             node=array.poll();
            System.out.print(node.val+" ");
            if(node.left!=null)
                array.add(node.left);
            if(node.right!=null)
                array.add(node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        MIrror m=new MIrror();
        m.LevelOrderTransversal(A);
        m.Mirror(A);
        System.out.println();
        m.LevelOrderTransversal(A);

    }
}
