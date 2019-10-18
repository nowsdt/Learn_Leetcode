package cn.supertao.hot100;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author shidt
 * @date 2019/10/8 23:00
 */
public class Solution003 {
    public static void main(String[] args) {
        final long start = System.nanoTime();
        final Integer length = lengthOfLongestSubstring("pwwkewkewf");
        System.out.println("耗时："+ (System.nanoTime() - start));
        System.out.println(length);

    }

    public static Integer lengthOfLongestSubstring(String str) {
        final int length;
        if (str == null || (length=str.length()) == 0) {
            return 0;
        }


        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {

                if (allUnique(str, i, j)) {
                    max = Math.max(max, j-i);
                }
            }
        }


        return 0;
    }

    /**
     *  字符串是否有重复字符
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static boolean allUnique(String str, int start, int end) {
        final HashSet<Character> set = new HashSet();

        for (int i = start; i < end; i++) {
            final char charAt = str.charAt(i);
            if (set.contains(charAt)) {
                return false;
            }

            set.add(charAt);
        }

        return true;
    }
}
