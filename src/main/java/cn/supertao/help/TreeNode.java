package cn.supertao.help;

/**
 * @author shidt
 * @date 2020/10/17 14:51
 */
public class TreeNode<T extends Number> {
    public T data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode next;

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("data=").append(data);
        sb.append(", leftChild=").append(leftChild);
        sb.append(", rightChild=").append(rightChild);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
