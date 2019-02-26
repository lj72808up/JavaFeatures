package binarytree;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class NextNodeInOrder {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null)
            return null;
        if (pNode.right != null){
            TreeLinkNode rc = pNode.right;
            while (rc.left != null)
                rc = rc.left;
            return rc;
        }else {
            while(isRightChild(pNode))
                pNode=pNode.next;
            return pNode.next;
        }
    }

    private boolean isRightChild(TreeLinkNode pNode){
        if (pNode==null)
            return false;
        TreeLinkNode parent = pNode.next;  // 父节点
        if (parent==null)
            return false;
        return parent.right==pNode;
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