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
        // reverse(head).print();
        reverseKGroup(head, 2).print();
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }




    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        final ListNode newHead = reverseBetween(a, b);

        a.next = reverseKGroup(b, k);

        return newHead;

    }

    /**
     * 反转区间[a,b) 不包括b
     *
     * @param head
     * @param node
     * @return
     */
    private ListNode reverseBetween(ListNode head, ListNode node) {
        ListNode cur = head, next = head, pre = null;

        while (cur != node) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
