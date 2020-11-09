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

    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
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


    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }
}
