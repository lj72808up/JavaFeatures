package binarytree;

import apple.laf.JRSUIUtils;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class RebuildBinaryTree {
    //从start开始,到end结束
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) throws Exception {
        return this.reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in,int startPre,int endPre,int startIn,int endIn) throws Exception {
        if (startPre > endPre)
            return null;
        System.out.println("start:"+startPre+",end:"+endPre);
        int rootVal = pre[startPre];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexof(in,rootVal,startIn,endIn);  // 中序遍历的root节点脚标
        int lengthLeft = rootIndex - startIn ;

        TreeNode left = reConstructBinaryTree(pre,in,
                startPre+1,
                startPre+lengthLeft,
                 startIn,
                rootIndex-1);

        TreeNode right = reConstructBinaryTree(pre,in,
                startPre+lengthLeft+1,
                endPre,
                rootIndex+1,
                endIn
                );
        root.left = left;
        root.right = right;
        return root;
    }

    private int indexof(int[] inArr,int target,int start,int end) throws Exception {
        for (int i = start; i <= end; i++) {
            if (inArr[i]==target)
                return i;
        }
        System.out.println(inArr+"::start::"+start+"::end::"+end+"::target::"+target);
        throw new Exception("not find this elem");
    }

    public void traverse(TreeNode root){
        if(root==null)
            return;
        traverse(root.left);
        traverse(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) throws Exception {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        RebuildBinaryTree tree = new RebuildBinaryTree();
        TreeNode root = tree.reConstructBinaryTree(pre, in);
//        TreeNode root = tree.reConstructBinaryTree(pre, in, 0, 6, 0, 6);
        tree.traverse(root);
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
