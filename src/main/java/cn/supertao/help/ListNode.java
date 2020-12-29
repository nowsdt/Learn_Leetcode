package cn.supertao.help;

import java.util.StringJoiner;

/**
 * @author shidt
 * @date 2020/10/17 14:51
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner("-->", "[", "]");

        ListNode head = this;

        joiner.add(String.valueOf(this.val));

        while (head.next != null) {
            joiner.add(String.valueOf(head.next.val));
            head = head.next;
        }
        return joiner.toString();
    }
}
