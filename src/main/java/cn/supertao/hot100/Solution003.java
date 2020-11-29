package cn.supertao.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
        final List<String> strList = Arrays.asList("abcabcbb", "bbbbb", "pwwkew");
        for (String str : strList) {
            final long start = System.nanoTime();
            final Integer length = lengthOfLongestSubstring(str);
            System.out.println("耗时："+ (System.nanoTime() - start)  + "ns");
            System.out.println(length);
        }
        System.out.println("======滑动窗口========");
        for (String str : strList) {
            final long start = System.nanoTime();
            final Integer length = lengthOfLongestSubstringSmoothWin(str);
            System.out.println("耗时："+ (System.nanoTime() - start)  + "ns");
            System.out.println(length);
        }
        System.out.println("=======滑动窗口优化0=======");
        for (String str : strList) {
            final long start = System.nanoTime();
            final Integer length = lengthOfLongestSubstringSmoothWinOpt0(str);
            System.out.println("耗时："+ (System.nanoTime() - start)  + "ns");
            System.out.println(length);
        }
        System.out.println("=======滑动窗口优化1=======");
        for (String str : strList) {
            final long start = System.nanoTime();
            final Integer length = lengthOfLongestSubstringSmoothWinOpt1(str);
            System.out.println("耗时："+ (System.nanoTime() - start)  + "ns");
            System.out.println("结果：" + length);
        }

        System.out.println("=======滑动窗口优化2=======");
        for (String str : strList) {
            final long start = System.nanoTime();
            final Integer length = lengthOfLongestSubstringSmoothWinOpt2(str);
            System.out.println("耗时："+ (System.nanoTime() - start)  + "ns");
            System.out.println("结果：" + length);
        }

    }

    /**
     * 优化的滑动窗口算法
     *
     * @param str
     * @return
     */
    public static Integer lengthOfLongestSubstringSmoothWinOpt2(String str) {
        int max = 0;
        final int length;
        if (str == null || (length = str.length()) == 0) {
            return 0;
        }

        //Map<char, index>
        final Map<Character, Integer> container = new HashMap();

        int i = 0;

        for (int j = 0; j < length; j++) {
            final char charAt = str.charAt(j);

            if (container.containsKey(charAt)) {
                i = Math.max(i, container.get(charAt));
            }

            container.put(charAt, j + 1);

            max = Math.max(max, j -i +1);

        }
        return max;
    }
    /**
     * 优化的滑动窗口算法
     *
     * @param str
     * @return
     */
    public static Integer lengthOfLongestSubstringSmoothWinOpt1(String str) {
        int max = 0;
        final int length;
        if (str == null || (length = str.length()) == 0) {
            return 0;
        }

        final Map<Character, Integer> mapping = new HashMap();

        int i = 0, j = 0;

        while (i < length && j < length) {
            // System.out.println("i:" + i + " j:" + j);
            // System.out.println("pre：" + mapping);
            final char charAt = str.charAt(j);
            if (mapping.containsKey(charAt)) {
                i = Math.max(i, mapping.get(charAt));
            }

            max = Math.max(max, j -i +1);
            mapping.put(charAt, j+1);
            j++;
            // System.out.println("after：" + mapping);
        }
        return max;
    }
    /**
     * 优化的滑动窗口算法
     *
     * @param str
     * @return
     */
    public static Integer lengthOfLongestSubstringSmoothWinOpt0(String str) {
        int max = 0;
        final int length;
        if (str == null || (length=str.length()) == 0) {
            return 0;
        }

        final Map<Character, Integer> mapping = new HashMap();

        int i = 0, j = 0;

        while (i < length && j < length) {
            // System.out.println("i:" + i + " j:" + j);
            // System.out.println("pre："+ mapping);
            final char charAt = str.charAt(j);
            if (mapping.containsKey(charAt)) {
                max = Math.max(max, mapping.size());
                mapping.remove(str.charAt(i));

                i = Math.max(++i, mapping.getOrDefault(charAt, 0));
            } else {
                mapping.put(charAt, j++);
            }
            // System.out.println("after："+ mapping);
        }


        return max;
    }

    /**
     * 滑动窗口算法
     *
     * @param str
     * @return
     */
    public static Integer lengthOfLongestSubstringSmoothWin(String str) {
        int max = 0;
        final int length;
        if (str == null || (length=str.length()) == 0) {
            return 0;
        }
        int i = 0, j = 0;
        final HashSet<Character> container = new HashSet();
        while (i < length && j< length) {
            if (container.contains(str.charAt(j))) {
                container.remove(str.charAt(i++));
            } else {
                container.add(str.charAt(j++));
                // max = Math.max(max, j-i );
                max = Math.max(max, container.size());
            }

            // System.out.println(container);

        }


        return max;
    }

    /**
     * 穷举
     *
     * @param str
     * @return
     */
    public static Integer lengthOfLongestSubstring(String str) {
        final int length;
        if (str == null || (length=str.length()) == 0) {
            return 0;
        }


        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                if (allUnique(str, i, j)) {
                    max = Math.max(max, j-i);
                }
            }
        }

        return max;
    }

    /**
     *  字符串是否有重复字符
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static boolean allUnique(String str, int start, int end) {
        // System.out.println(str.substring(start, end));
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