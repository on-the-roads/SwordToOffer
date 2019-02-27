package com.Solution.Tree;
import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点
 * 形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * //思路：用前序遍历方法遍历树的节点，遍历当前节点时，将该节点的数值加入temp数组，同时target减去该数值，判断该节点是否为叶节点并且target为0，
 * 若满足，则将temp加入ans表中；
 * 不满足，继续递归遍历该节点的左子树和右子树。
 * 当前节点访问结束后，递归函数将自动回到它的父节点，所以在返回前要将temp的最后一个结点删除，从而保证返回父节点时temp中的路径刚好是根节点到父节点的路径。
 */
public class FINDPath {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> temp=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null)
            return ans;
        target=target-root.val;
        temp.add(root.val);
        if(target==0&&root.left==null&&root.right==null)
        {
            ans.add(new ArrayList<Integer>(temp));
        }
        else {
            FindPath(root.left,target);
            FindPath(root.right,target);
          //  target=target+root.val;
        }
        temp.remove(temp.size()-1);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        ArrayList<ArrayList<Integer>> a=new FINDPath().FindPath(root,5);

    }
}
