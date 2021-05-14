package cn.supertao.linked;

import cn.supertao.help.ListNode;
import cn.supertao.utils.ListNodeUtils;
import org.junit.Test;

/**
 * @author shidt
 * @date 2021/5/9 17:36
 */
public class LinkedRemoveTailN {

    @Test
    public void testRemoveTailN() {
        final ListNode head = ListNodeUtils.gen();
        removeTailK(head, 6).print();

    }

    /**
     * 删除链表倒数第K个结点
     */
    private ListNode removeTailK(ListNode head, int k) {
        ListNode fast = head;

        while (k > 0) {
            k--;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }
        }

        // head刚好是倒数第k节点
        if (fast == null) {
            return head.next;
        }

        ListNode slow = head;
        ListNode pre = null;

        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(pre.val);
        System.out.println(slow.val);

        pre.next = slow.next;
        return head;
    }

}
