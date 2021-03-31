package cn.supertao.linked;

import cn.supertao.help.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author shidt
 * @date 2021/3/30 17:32
 */
public class TwoLinkSum {

    @Test
    public void testTwoSum() {
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

        System.out.println(node1);
        System.out.println(node4);

        // twoSum(node1, node4).print();

        // reverseNode(node1).print();
        reverseNodeCycle(node1).print();
    }

    public ListNode twoSum(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == null? n2: n1;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (n1 != null || n2 != null) {
            if (n1 != null) {
                s1.push(n1);
                n1 = n1.next;
            }
            if (n2 != null) {
                s2.push(n2);
                n2 = n2.next;
            }
        }

        int len = Math.max(s1.size(), s2.size());

        int carry = 0;
        ListNode head = null;
        for (int i = 0; i < len; i++) {
            int num;

            if (!s1.isEmpty() && !s2.isEmpty()) {
                final ListNode pop1 = s1.pop();
                final ListNode pop2 = s2.pop();
                num = pop1.val + pop2.val + carry;
            } else if (!s1.isEmpty()) {
                final ListNode pop1 = s1.pop();
                num = pop1.val + carry;
            } else {
                final ListNode pop2 = s2.pop();
                num = pop2.val + carry;
            }

            final ListNode node = new ListNode(num % 10);
            node.next = head;
            head = node;
            carry = num / 10;
        }

        if (carry > 0) {
            final ListNode node = new ListNode(carry);
            node.next = head;
            head = node;

        }

        return head;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        final ListNode reverseNode = reverseNode(head.next);
        head.next.next = head;
        head.next = null;


        return reverseNode;
    }

    private ListNode reverseNodeCycle(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }

        ListNode pre = null, cur = head, next = head;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            // pre.next = null;
            pre = cur;
            cur = next;

        }

        return pre;
    }
}
