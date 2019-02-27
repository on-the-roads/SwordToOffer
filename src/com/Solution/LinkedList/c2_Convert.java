package com.Solution.LinkedList;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
/*思路：利用二叉搜索树的中序遍历思路
 （非递归方法）
 */
public class c2_Convert {
    TreeNode head = null;
    TreeNode end = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        InOrderTravesal(pRootOfTree);
        return head;
    }

    public void InOrderTravesal(TreeNode root) {

        Stack stack = new Stack();
        while (root != null||!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = (TreeNode) stack.pop();
                if (end == null)
                    head = end = root;
                else {
                    end.right = root;
                    root.left = end;
                    end = end.right;
                }
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode end = null;
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode head = new c2_Convert().convert(root);
        System.out.println("从左到右：");
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.right;
        }
        System.out.println("\r\n从右到左：");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.left;
        }
    }
}
