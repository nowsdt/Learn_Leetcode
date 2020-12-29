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
        final StringJoiner joiner = new StringJoiner("-->","[","]");

        ListNode head = this;
        if (head != null) {
            joiner.add(this.val + "");

            while (head.next != null) {
                joiner.add(head.next.val + "");
                head = head.next;
            }
        }

        System.out.println(joiner.toString());
    }
}
