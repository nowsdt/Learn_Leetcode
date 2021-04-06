package cn.supertao;

import cn.supertao.help.ListNode;
import cn.supertao.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author shidt
 * @date 2021/4/6 15:02
 */
public class LinkListTest {

    @Test
    public void testReverse() {
        final ListNode head = ListNodeUtils.gen();
        final ListNode node = reverseNode(head);
        node.print();
        reverseNode1(node).print();
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode node = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, next = head.next;

        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
