package cn.supertao.dp;

/**
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *  https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author shidt
 * @date 2020/11/30 12:26
 */
public class PalindRome {

    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }

    public static void  longestPalindromeSubseq(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            final String s1 = palindrome(s, i, i);
            final String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length()? res: s1;
            res = res.length() > s2.length()? res: s2;
        }

        System.out.println("s:"+s + ",result:"+ res);


    }

    public static String palindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length()
                && s.charAt(start) == s.charAt(end)) {

            start--;
            end++;
        }
        System.out.println("============");
        System.out.println(start + ":" + end);
        System.out.println("s:" + s+" index start:  " + (start+1) + " end index:" + (end-start - 1));
        return s.substring(start, end);
    }
}
