package com.Solution.Tree;

//Definition for binary tree
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
  class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class COnstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0)
            return  null;
        return  ConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode ConstructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps>pe||is>ie)
            return null;
        TreeNode root=new TreeNode(pre[ps]);
        for(int i=is;i<=ie;i++)
        {
            if(in[i]==pre[ps]){
                root.left=ConstructBinaryTree(pre,ps+1 ,ps+i-is ,in,is,i-1);
                root.right=ConstructBinaryTree(pre,ps+i-is+1,pe,in,i+1,ie);
            }
        }
        return root;
    }

    public  void PreTranversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            PreTranversal(root.left);
            PreTranversal(root.right);
        }
    }
        public  void InTranversal(TreeNode root){
        if(root!=null)
        {
            InTranversal(root.left);
            System.out.println(root.val);
            InTranversal(root.right);
        }

    }


    public static void main(String[] args) {
        COnstructBinaryTree solution=new COnstructBinaryTree();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root=solution.reConstructBinaryTree(pre,in);
        solution.InTranversal(root);
     //   solution.PreTranversal(root);
    }
}
