package binarytree;

import apple.laf.JRSUIUtils;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return this.reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in,int startPre,int endPre,int startIn,int endIn) {
        if (startPre > endPre)
            return null;
        System.out.println("start:"+startPre+",end:"+endPre);
        int rootVal = pre[startPre];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexof(in,rootVal);  // 中序遍历的root节点角标
        int lengthLeft = rootIndex - startIn + 1;
        int lengthRight = endIn - rootIndex + 1;

        TreeNode left = reConstructBinaryTree(pre,in,
                startPre+1,
                startPre+lengthLeft,
                startIn,
                startIn+lengthLeft-1);

        TreeNode right = reConstructBinaryTree(pre,in,
                startPre+lengthLeft+1,
                startPre+lengthLeft+lengthRight,
                startIn+lengthLeft+1,
                startIn+lengthLeft+lengthRight
                );
        root.left = left;
        root.right = right;
        return root;
    }

    private int indexof(int[] inArr,int target){
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i]==target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        new RebuildBinaryTree().reConstructBinaryTree(pre,in,0,6,0,6);
    }

}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
