package cn.supertao.linked;

import cn.supertao.help.ListNode;

/**
 * @author shidt
 * @date 2020/12/21 20:07
 *
 */
public class LinkedReverse {

    public static void main(String[] args) {
        final LinkedReverse alg = new LinkedReverse();

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

        alg.reverse1(node1).print();
        // alg.print(alg.reverse2(node1));
        // alg.print(alg.reverseN(node1, 3));
        // alg.reverseN(node1, 3).print();
        // alg.reverseBetween(node1,2,  3).print();
        // alg.reverseKGroup(node1,2).print();


    }


    /**
     * 反转从位置m到n的链表，请使用一趟扫描完成
     * input:1 2 3 4 5  m,n=2,4
     * output:1 4 3 2 5
     *
     * 索引从1开始
     *
     *  循环
     *
     */
    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr, next, pre;
        curr = next =  head;
        pre = null;


        while (curr != null) {
           next = curr.next;

           curr.next = pre;
           pre = curr;
           curr = next;
        }

        return pre;
    }


    /**
     * 递归
     *
     */
    private ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        final ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    ListNode successor = null;

    /**
     * 递归
     *
     */
    private ListNode reverseN(ListNode head, int n) {
        if (n ==1 ) {
            successor = head.next;
            return head;
        }

        final ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;

        return last;
    }



    /**
     * 递归
     *
     */
    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        final ListNode last = reverseBetween(head.next, m - 1, n - 1);
        head.next = last;

        return head;
    }

    /**
     * 左开右闭区间
     *
     *
     */
    private ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pred, curr, next;
        curr = next = a;
        pred = null;

        while (curr != b) {
            next = curr.next;

            curr.next = pred;
            pred = curr;
            curr = next;
        }

        return pred;
    }


    /**
     * 递归
     *
     */
    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a,b;
        a= b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }

        final ListNode newHead = reverseBetween(a, b);
        a.next = reverseKGroup(b, k);

        return newHead;
    }
}
