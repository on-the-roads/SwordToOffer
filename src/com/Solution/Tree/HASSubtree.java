package com.Solution.Tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HASSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {//遍历root1，判断是否含有root2的根节点
        if (root1 == null || root2 == null)
            return false;
        boolean result = false;
        if (!result)
            result = Hasroot(root1, root2);
        if (!result)
            result = HasSubtree(root1.left, root2);
        if (!result)
            result = HasSubtree(root1.right, root2);
        return result;
    }

    boolean Hasroot(TreeNode root1, TreeNode root2) {//在root1中找到根结点后判断是不是子树。
        if (root2 == null)//对root2的判断要放在root1前面
            return true;
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val)
            return false;
        return Hasroot(root1.left, root2.left) && Hasroot(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.left.left = new TreeNode(3);
        A.left.right = new TreeNode(4);
        TreeNode B = new TreeNode(2);
        B.left = new TreeNode(3);
//        B.right=new TreeNode(4);
        HASSubtree s = new HASSubtree();
        boolean ans = s.HasSubtree(A, B);
        System.out.println(ans);
    }
}
