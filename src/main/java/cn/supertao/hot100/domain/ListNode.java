package cn.supertao.hot100.domain;

import java.util.Objects;

/**
 * @author shidt
 * @date 2019/8/8 12:46
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode setNextAndGet(ListNode next) {
        this.next = next;
        return next;
    }

    public boolean hasNext() {
        return Objects.nonNull(this.next);
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}
