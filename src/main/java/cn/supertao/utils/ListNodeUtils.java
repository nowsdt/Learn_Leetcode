package cn.supertao.utils;

import cn.supertao.help.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shidt
 * @date 2021/4/6 15:00
 */
public class ListNodeUtils {
    public static ListNode gen() {
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

        head.print();
        return head;
    }

    public static ListNode genQueue(Integer... nums) {

        Queue<ListNode> queue = new LinkedList<>();
        for (Integer num : nums) {
            queue.add(new ListNode(num));
        }


        ListNode dumbNode = new ListNode(-1);
        ListNode head = dumbNode;
        while (!queue.isEmpty()) {
            dumbNode.next = queue.poll();
            dumbNode = dumbNode.next;
        }

        return head.next;
    }

    public static ListNode gen(Integer... nums) {
        Stack<ListNode> stack = new Stack<>();
        for (Integer num : nums) {
            stack.add(new ListNode(num));
        }


        ListNode head = stack.pop();
        while (!stack.isEmpty()) {
            final ListNode pop = stack.pop();
            pop.next = head;
            head = pop;
        }

        return head;
    }
}
