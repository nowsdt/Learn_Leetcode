package cn.supertao.hot100;

import cn.supertao.hot100.domain.ListNode;
import cn.supertao.utils.MapUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author shidt
 * @date 2019/8/5 13:23
 */
public class Solution002 {
    public static void main(String[] args) {
        final List<ListNode> nodeList = getListNodes();
        final ListNode head1 = nodeList.get(0);
        final ListNode head2 = nodeList.get(1);
        printListNode(head1);
        printListNode(head2);



    }

    public static ListNode addTwoNode(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);

        if (head1 == null && head2 != null) {
            ListNode curr1 = head2;
            result = new ListNode(curr1.getVal());

            while ((curr1 = head2.getNext()) != null) {
                ListNode temp = result;
                result = new ListNode(curr1.getVal());
                result.setNext(temp);
                curr1 = curr1.getNext();
            }
        }

        return result;
    }

    /**
     *  generate LinkedList
     * @return
     */
    public static List<ListNode> getListNodes() {
        ListNode head1 = new ListNode(2);

        ListNode next1 = new ListNode(5);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(1);
        ListNode next4 = new ListNode(6);

        head1.setNextAndGet(next1)
                .setNextAndGet(next2)
                .setNextAndGet(next3)
                .setNextAndGet(next4);

        ListNode head2 = new ListNode(2);

        head2.setNextAndGet(new ListNode(15))
                .setNextAndGet(new ListNode(8))
                .setNextAndGet(new ListNode(1));

        return Arrays.asList(head1, head2);
    }

    public static void printListNode(ListNode head) {
        if (head == null) return;

        final StringJoiner joiner = new StringJoiner("->", "[", "]");
        ListNode node = head;

        joiner.add(String.valueOf(node.getVal()));
        do {
            node = node.getNext();
            joiner.add(String.valueOf(node.getVal()));
        } while (node.hasNext());

        System.out.println(joiner.toString());
    }
}
