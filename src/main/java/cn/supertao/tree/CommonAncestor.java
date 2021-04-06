package cn.supertao.tree;

import cn.supertao.help.TreeNode;
import org.junit.Test;

/**
 * @author shidt
 * @date 2021/4/3 21:45
 */
public class CommonAncestor {

    @Test
    public void testLowestCommonAncestor() {

    }

    /**
     *
     * 二叉树的最近公共祖先
     *
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485561&idx=1&sn=a394ba978283819da1eb34a256f6915b&chksm=9bd7f671aca07f6722f0bc1e946ca771a0a40fd8173cc1227a7e0eabfe4e2fcc57b9ba464547&scene=21#wechat_redirect
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) return null;
        if (root == p || root ==q) return root;

        final TreeNode left = lowestCommonAncestor(root.leftChild, q, q);
        final TreeNode right = lowestCommonAncestor(root.rightChild, q, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null? right: left;
    }
}
