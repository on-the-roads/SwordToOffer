package com.Solution.Tree;

import java.util.Stack;

/**
 * 题目：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 思路1:(递归思想) 先判断根的左子树和右子树是否相同；
 *                再判断左子树的右子树和右子树的左子树是否相同，左子树的左子树和右子树的右子树是否相同。
 * 思路2：（非递归方法）利用栈
 */

public class ISSymmetrical {
//    /**
//     * 思路1
//     * @param pRoot
//     * @return
//     */
//    boolean isSymmetrical(TreeNode pRoot) {
//        if (pRoot == null)
//            return true;
//        return isSymmetrical(pRoot.left, pRoot.right);
//    }
//
//    private boolean isSymmetrical(TreeNode ltree, TreeNode rtree) {
//        if (ltree == null && rtree == null)
//            return true;
//        else if (ltree == null || rtree == null)
//            return false;
//        else if (ltree.val == rtree.val)
//            return isSymmetrical(ltree.left, rtree.right) && isSymmetrical(ltree.right, rtree.left);
//        return false;
//    }

    /**
     * 思路2
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return  true;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty())
        {
            TreeNode right=stack.pop();
            TreeNode left=stack.pop();
            if(right==null&&left==null)
                return true;
            if(right==null||left==null)
                return false;
            if(right.val!=left.val)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(right.left);
            stack.push(left.right);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean res = new ISSymmetrical().isSymmetrical(root);
    }
}
