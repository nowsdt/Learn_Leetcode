package cn.supertao.linked;

import cn.supertao.help.ListNode;
import org.junit.Test;

/**
 * @author shidt
 * @date 2021/5/8 16:10
 */
public class LinkedCircle {
    @Test
    public void testCircle() {
        final ListNode head = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);
        final ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node6.next = node4;
        final ListNode circle = findCircle(head);

        System.out.println(circle.val);

    }

    public ListNode findCircle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
