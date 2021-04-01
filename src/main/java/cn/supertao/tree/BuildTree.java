package cn.supertao.tree;

import cn.supertao.help.TreeNode;
import org.junit.Test;

/**
 *
 * 前序遍历或者后续遍历构造二叉树
 *
 *
 * 一个节点的左节点是其父节点下标的2k+1，右节点是其父节点下标的2K+2。
 *
 * @author shidt
 * @date 2021/4/1 7:35
 */
public class BuildTree {

    @Test
    public void testBuildTree() {

    }

    /**
     * 先序遍历
     * @param preorder 先序遍历结果
     * @param inorder  中序遍历结果
     * @return
     */
    private TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        Integer rootVal = preorder[0];
        int leftVal = preorder[1];
        int rightVal = inorder[0];

        TreeNode<Integer> root = new TreeNode<>(rootVal);

        return root;
    }

    /**
     * 中序遍历
     *
     * @return
     */
    private TreeNode<Integer> build(int[] preOrder,int preStart, int preEnd,
                                    int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        // 先序遍历第一个为根节点
        int rootVal = preOrder[preStart];
        // 找中序遍历的根节点
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inOrder[i]) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode<Integer> root = new TreeNode<>(0);
        root.leftChild = build(preOrder, preStart+1, preStart+leftSize, inOrder, inStart, index - 1);
        root.rightChild = build(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);

        return root;
    }


}
