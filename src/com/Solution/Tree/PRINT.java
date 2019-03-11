package com.Solution.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路：设置两个堆栈，一个用来存放奇数行的s1,一个用来存放偶数行的s2。
 *      其中奇数行先存放右子树后存放左子树，偶数行先存放左子树后存放右子树。
 */
public class PRINT {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();//存放奇数行
        Stack<TreeNode> s2 = new Stack<TreeNode>();//存放偶数行
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        TreeNode node = pRoot;
        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                node = s1.pop();
                temp.add(node.val);
                //偶数行先存放左子树后存放右子树
                if (node.left != null)
                    s2.push(node.left);
                if (node.right != null)
                    s2.push(node.right);
            }
            if (temp.size() != 0) {
                ans.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
            while (!s2.isEmpty()) {
                node = s2.pop();
                temp.add(node.val);
                //奇数行先存放右子树后存放左子树
                if (node.right != null)
                    s1.push(node.right);
                if (node.left != null)
                    s1.push(node.left);
            }
            if (temp.size() != 0) {
                ans.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> ans = new PRINT().Print(A);
    }
}
