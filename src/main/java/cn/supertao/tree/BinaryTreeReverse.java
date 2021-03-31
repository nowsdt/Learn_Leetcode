package cn.supertao.tree;

import cn.supertao.help.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author shidt
 * @date 2021/3/31 17:01
 */
public class BinaryTreeReverse {


    @Test
    public void testTreeReverse() {
        final LinkedList<Integer> data = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        final TreeNode root = buildTree(data);
        System.out.println(root);

    }


    public TreeNode buildTree(LinkedList<Integer> data) {
        TreeNode<Integer> root = null;
        if (data.isEmpty()) {
            return root;
        }
        final Integer first = data.removeFirst();

        root = new TreeNode<>(first);
        root.leftChild = buildTree(data);
        root.rightChild = buildTree(data);

        return root;
    }

}
