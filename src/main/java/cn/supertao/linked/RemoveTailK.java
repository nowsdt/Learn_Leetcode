package cn.supertao.linked;

import cn.supertao.help.ListNode;
import org.junit.Test;

/**
 *
 * 移除倒数第n个节点
 *
 * @author shidt
 * @date 2021/3/31 13:52
 */
public class RemoveTailK {
    @Test
    public void testTailK() {
        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);
        final ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node1.print();
        System.out.println("==============================");

        removeTailK(node1, 3).print();
    }

    private ListNode removeTailK(ListNode head, int pos) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;

            for (int i = 0; i < pos; i++) {
                fast = fast.next;
            }
        }

        slow.next = slow.next.next;

        return head;
    }
}
