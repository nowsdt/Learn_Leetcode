package cn.supertao.help;

/**
 *
 * 双向链表
 * @author shidt
 * @date 2021/3/22 17:11
 */
public class DoubleLinkedList {
    private Node head, tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.pre = head;

        size = 0;
    }

    public void addLast(Node node) {
        node.next = tail;
        node.pre = tail.pre;

        tail.pre.next = node;
        tail.pre = node;

        size++;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        size--;
    }

    public Node removeFirst() {
        final Node next = head.next;
        if (next == tail) {
            return null;
        }
        remove(next);
        return next;
    }

    public Integer size() {
        return size;
    }
}
