package com.Solution.Tree;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：层序遍历
 * 利用队列实现
 */
public class PRINTFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) throws InterruptedException {
        ArrayList<Integer>list=new ArrayList<>();
        if(root==null) {
            return  list;
        }
        LinkedBlockingQueue<TreeNode> quene=new LinkedBlockingQueue<TreeNode>();
        Integer ele=0;
        TreeNode node=root;
        quene.put(node);
        while(!quene.isEmpty()&&node!=null){
            node=quene.poll();
            list.add(node.val);
            if(node.left!=null)
                quene.put(node.left);
            if(node.right!=null)
                quene.put(node.right);
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right=new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        PRINTFromTopToBottom p=new PRINTFromTopToBottom();
        ArrayList<Integer> list=p.PrintFromTopToBottom(A);
        for(Integer i:list)
            System.out.println(i);
    }
}
