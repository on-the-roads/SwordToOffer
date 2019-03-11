package com.Solution.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 思路1：用双队列实现
 * 思路2：用单队列实现
 */
public class PrintLevelFromleftToRight {
//    /**
//     *  思路1：用双队列实现
//     * @param pRoot
//     * @return
//     */
//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        Queue<TreeNode> q1=new LinkedList<>();
//        Queue<TreeNode> q2=new LinkedList<>();
//        ArrayList<Integer> temp = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        if (pRoot == null)
//            return ans;
//
//        TreeNode node = pRoot;
//        q1.offer(node);
//        while (!q1.isEmpty() || !q2.isEmpty()) {
//            while (!q1.isEmpty()) {
//                node = q1.poll();
//                temp.add(node.val);
//                if (node.left != null) {
//                    q2.offer(node.left);
//                }
//                if (node.right != null) {
//                    q2.offer(node.right);
//                }
//            }
//            if (temp.size() != 0) {
//                ans.add(new ArrayList<Integer>(temp));
//                temp.clear();
//            }
//            while (!q2.isEmpty()) {
//                node = q2.poll();
//                temp.add(node.val);
//                if (node.left != null)
//                    q1.offer(node.left);
//                if (node.right != null) {
//                    q1.offer(node.right);
//                }
//            }
//            if (temp.size() != 0) {
//                ans.add(new ArrayList<Integer>(temp));
//                temp.clear();
//            }
//        }
//        return ans;
//    }

    /**
     * 思路2：单队列实现
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        q.offer(pRoot);
        TreeNode node=pRoot;
        int start=0;
        int end=1;
        while (!q.isEmpty())
        {
            node=q.poll();
            start++;
            temp.add(node.val);
            if(node.left!=null)
                q.offer(node.left);
            if(node.right!=null)
                q.offer(node.right);
            if(start==end)
            {
                ans.add(new ArrayList<>(temp));
                start=0;
                end=q.size();
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
        ArrayList<ArrayList<Integer>> ans = new PrintLevelFromleftToRight().Print(A);
    }

}
