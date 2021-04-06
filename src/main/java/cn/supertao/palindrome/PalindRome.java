package cn.supertao.palindrome;

import cn.supertao.help.ListNode;
import cn.supertao.utils.ListNodeUtils;
import org.junit.Test;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author shidt
 * @date 2020/11/30 12:26
 */
public class PalindRome {

    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
        ListNodeUtils.gen(1,2,3,4,5,6).print();
    }

    public static void longestPalindromeSubseq(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            final String s1 = palindrome(s, i, i);
            final String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        System.out.println("s:" + s + ",result:" + res);


    }

    public static String palindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length()
                && s.charAt(start) == s.charAt(end)) {

            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    ListNode left = null;
    boolean rest = Boolean.FALSE;

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484822&idx=1&sn=44742c9a3557038c8da7150100d94db9&chksm=9bd7fb9eaca0728876e1146306a09f5453bcd5c35c4a264304ea6189faa83ec12a00322f0246&scene=21#wechat_redirect
     *
     */
    @Test
    public void testPalindRomeNode() {
        ListNode head = ListNodeUtils.gen(1,2,3,4,3,2,1,2);
        head.print();

        left = head;
        isPalindRomeNode(head);
        System.out.println(rest);
    }

    private boolean isPalindRomeNode(ListNode right) {
        if (right == null) return true;
        final boolean palindRomeNode = isPalindRomeNode(right.next);
        rest = (palindRomeNode && left.val == right.val);
        left = left.next;
        return rest;
    }

    @Test
    public void doublePointer() {
        final ListNode head = ListNodeUtils.gen(1, 2, 3, 2,1);
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        boolean is = Boolean.FALSE;
        while (right != null) {
            if (left.val != right.val) {
                is = Boolean.FALSE;
                break;
            }
            left = left.next;
            right = right.next;
        }
        System.out.println(is);

    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

}
