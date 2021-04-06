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
     * @param preOrder 先序遍历结果
     * @param inOrder  中序遍历结果
     * @return
     */
    private TreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        return buildPreIn(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 先序遍历，中序遍历
     *
     * @return
     */
    private TreeNode<Integer> buildPreIn(int[] preOrder, int preStart, int preEnd,
                                         int[] inOrder, int inStart, int inEnd) {
        // bad case
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
        root.leftChild = buildPreIn(preOrder, preStart+1, preStart+leftSize, inOrder, inStart, index - 1);
        root.rightChild = buildPreIn(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);

        return root;
    }


    /**
     * 先序遍历，中序遍历
     *
     * @return
     */
    private TreeNode<Integer> buildPostIn(int[] inOrder, int inStart, int inEnd,
                                          int[] postOrder, int postStart, int postEnd) {
        // bad case
        if (postStart > postEnd) return null;

        // 先序遍历第一个为根节点
        int rootVal = postOrder[postEnd];
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
        root.leftChild = buildPostIn(inOrder, inStart, index -1,
                postOrder, postStart, postStart + leftSize -1);
        root.rightChild = buildPostIn(inOrder, inStart+1, inEnd,
                postOrder, postStart+leftSize, postEnd - 1);

        return root;
    }


}
