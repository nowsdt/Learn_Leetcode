package cn.supertao.tree;

import cn.supertao.help.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author shidt
 * @date 2020/10/17 15:06
 */
public class TreeTest {

    public static void main(String[] args) {
        final LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        final TreeNode root = createBinaryTree(inputList);
        System.out.println();
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode<Integer> node = null;
        if (inputList == null || inputList.isEmpty()) {
            return node;
        }
        final Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }


    public static void preOrderTraveral(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
     * @param root
     * @return
     */
    TreeNode connect(TreeNode root) {
        if (root == null)  return root;
        connectTwoNode(root.leftChild, root.rightChild);
        return root;
    }

    void connectTwoNode(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return;
        n1.next = n2;

        connectTwoNode(n1.leftChild, n1.rightChild);
        connectTwoNode(n2.leftChild, n2.rightChild);
        // 跨父节点的节点
        connectTwoNode(n1.rightChild, n2.leftChild);
    }
}
