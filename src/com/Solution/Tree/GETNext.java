package com.Solution.Tree;

/**
 * 题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/**
 * 思路：1.首先判断结点是否为null，是则返回null；
 * 2.节点有右子树，返回右子树的最左子树；
 * 3.节点无右子树
 * （1）当前结点是父节点的左子树，则返回父节点
 * （2）当前结点是父节点的右子树，将父节点赋予当前结点，再次判断结点是否为父节点的左子树，重复（1）直到当前结点没有父节点，返回null
 */
public class GETNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        TreeLinkNode node = pNode;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.next != null) {
            if (node == node.next.left)
                return node.next;
            else {
                node = node.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode ltree = new TreeLinkNode(2);
        ltree.next = root;
        TreeLinkNode rtree = new TreeLinkNode(3);
        rtree.next = root;
        root.left = ltree;
        root.right = rtree;
        TreeLinkNode ans = new GETNext().GetNext(rtree);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
