package cn.supertao.tree;

import cn.supertao.help.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shidt
 * @date 2020/10/17 15:06
 */
public class TreeTest {

    public static void main(String[] args) {
        // final LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        // final LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1,2, -1, 4, 3, -1,-1));
        // final LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1,2, -1,4, -1,-1, 3, -1, -1));
        final LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, 2, null, 4, null, null, 3, null, null));
        final TreeNode root = createBinaryTree(inputList);
        layerTraverse(root);
    }


    /**
     * 先序遍历
     *
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode<Integer> root = null;
        if (inputList.isEmpty()) {
            return null;
        }
        final Integer data = inputList.removeFirst();
        if (data != null) {
            root = new TreeNode(data);
            root.leftChild = createBinaryTree(inputList);
            root.rightChild = createBinaryTree(inputList);
            System.out.println("right:" + root.rightChild);
        }

        return root;
    }


    public static void preOrderTraverse(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }


    /**
     * 二叉树层级遍历--队列实现
     *
     * @param root
     */
    public static void layerTraverse(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode<Integer> cur = queue.poll();
            System.out.println(cur.data);

            if (cur.leftChild != null) {
                queue.offer(cur.leftChild);
            }

            if (cur.rightChild != null) {
                queue.offer(cur.rightChild);
            }
        }

    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
     *
     * @param root
     * @return
     */
    TreeNode connect(TreeNode root) {
        if (root == null) return root;
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


    /**
     * 树拉伸成链表
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 左右节点拉平
        flatten(root.leftChild);
        flatten(root.rightChild);


        final TreeNode leftChild = root.leftChild;
        final TreeNode rightChild = root.rightChild;

        // 左边节点放到右边
        root.leftChild = null;
        root.rightChild = leftChild;

        // 所有右节点链接起来
        TreeNode tmp = root;
        while (tmp.rightChild != null) {
            tmp = tmp.rightChild;
        }

        tmp.rightChild = rightChild;

    }

    /**
     * 构造最大二叉树
     * 先来道简单的，这是力扣第 654 题，题目如下：
     * <p>
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=21#wechat_redirect
     *
     * @param nums
     */
    public void constructMaximumBinaryTree(int[] nums) {

        build(nums, 0 , nums.length);
    }

    public TreeNode<Integer> build(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int max = Integer.MIN_VALUE;
        int idx = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode<Integer> root = new TreeNode<>(max);

        root.leftChild = build(nums, lo, idx);
        root.rightChild = build(nums, idx + 1, hi);


        return root;
    }

}
