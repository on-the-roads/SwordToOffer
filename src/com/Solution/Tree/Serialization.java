package com.Solution.Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路：
 *       * 序列化：先序顺序将每个节点的值以“val，”的形式存在String中，对于空节点，用”#，“的形式存储
 *       * 反序列化：将序列化获得的String对象以“，”分割，放入队列中，按照先序的顺序构建二叉树。
 */
public class Serialization {
    String Serialize(TreeNode root) {
        if (root == null)
            return "#,";
        StringBuffer temp = new StringBuffer(root.val + ",");
        temp.append(Serialize(root.left));
        temp.append(Serialize(root.right));
        return temp.toString();
    }

    TreeNode Deserialize(String str) {
        Queue<String> queue = new LinkedList<>();
        String[] s = str.split(",");
        for (int i = 0; i < s.length; i++) {
            queue.offer(s[i]);
        }
        return q(queue);
    }

    private TreeNode q(Queue<String> queue) {

        String val = queue.poll();
        if(val.equals("#"))
            return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=q(queue);
        node.right=q(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        Serialization serialization=new Serialization();
        String temp=serialization.Serialize(root);
        TreeNode ans=serialization.Deserialize(temp);
    }
}
