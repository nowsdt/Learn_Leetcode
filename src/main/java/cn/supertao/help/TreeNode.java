package cn.supertao.help;

/**
 * @author shidt
 * @date 2020/10/17 14:51
 */
public class TreeNode<T> {
    public T data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode next;

    public TreeNode(T data) {
        this.data = data;
    }
}
