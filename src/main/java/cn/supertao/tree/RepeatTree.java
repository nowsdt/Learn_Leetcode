package cn.supertao.tree;

import cn.supertao.help.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 寻找重复子树
 *
 * @author shidt
 * @date 2021/4/1 14:57
 */
public class RepeatTree {

    /**
     * 力扣第 652 题「寻找重复子树」
     * <p>
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=21#wechat_redirect
     */
    List<TreeNode<Integer>> findDuplicateSubtrees(TreeNode<Integer> root) {
        traverse(root);
        return result;
    }

    private final List<TreeNode<Integer>> result = new ArrayList<>();
    private final HashSet<String> memo = new HashSet<>();

    private String traverse(TreeNode<Integer> root) {
        if (root == null) return "#";
        String left = traverse(root.leftChild);
        String right = traverse(root.rightChild);

        String tree = left + ","+ right + "," + root.data;

        if (!memo.contains(tree)) {
            result.add(root);
        }
        return tree;
    }
}
