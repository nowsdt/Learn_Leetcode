package cn.supertao.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shidt
 * @date 2021/4/4 22:06
 */
public class BackTrack {


    private static final List<List<Integer>> result = new ArrayList<>();

    @Test
    public void testPermute() {

        final LinkedList<Integer> track = new LinkedList<>();
        int[] arr = {1, 2};
        permute(arr, track);
        System.out.println(result);
    }

    /**
     *
     * 全排列
     *
     * @param nums
     * @return
     */
    public void permute(int[] nums,  LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            permute(nums, track);
            track.removeLast();
        }
    }

    /**
     * 子集
     */
    @Test
    public void testSubSets() {
        final LinkedList<Integer> track = new LinkedList<>();
        int[] arr = {1, 2, 3};
        subSets(arr, 0, track);
        System.out.println(result);
    }

    public void subSets(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            subSets(nums, i + 1, track);
            track.removeLast();
        }
    }


    @Test
    public void testCombine() {
        final LinkedList<Integer> track = new LinkedList<>();
        combine(4, 2, 0, track);
        System.out.println(result);
    }

    public void combine(int n, int k, int start,  LinkedList<Integer> track) {

        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            combine(n, k, i +1,  track);
            track.removeLast();
        }
    }


    private final List<String> bracketResult = new ArrayList<>();
    /**
     * 括号生成
     */
    @Test
    public void testBracketGen() {
        int bracket = 3;

        final LinkedList<Character> track = new LinkedList();
        bracketGen(bracket, bracket, track);

        bracketResult.forEach(System.out::println);
    }

    public void bracketGen(int left, int right, LinkedList<Character> track) {
        if (left > right) return;
        if (left < 0 || right < 0 ) return;
        if (left == 0  && right == 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            track.forEach(stringBuilder::append);
            bracketResult.add(stringBuilder.toString());
            return;
        }

        track.add('(');
        bracketGen(left -1, right, track);
        track.removeLast();

        track.add(')');
        bracketGen(left, right -1, track);
        track.removeLast();
    }
}
