package cn.supertao.help;

/**
 * @author shidt
 * @date 2021/3/22 17:23
 */
public class Node {
    public Integer key;
    public Integer value;

    public Node pre;
    public Node next;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
