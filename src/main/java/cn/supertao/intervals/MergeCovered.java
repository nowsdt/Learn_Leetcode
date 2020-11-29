package cn.supertao.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * 合并区间
 *
 * @author shidt
 * @date 2020/11/7 14:52
 */
public class MergeCovered {

    // intervals = [[1,3],[2,6],[8,10],[15,18]]
    // 输出[[1,6],[8,10],[15,18]]
    // [1,3]和[2,6]重叠，合并为[1,6]
    //

    public static void merge(Integer[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (Integer[] next : intervals) {
            System.out.print(next[0] + "," + next[1] + " ");
        }

        System.out.println("\n==============================\n");
        LinkedList<Integer[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            final Integer[] curr = intervals[i];
            final Integer[] last = result.getLast();

            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else {
                result.add(curr);
            }
        }

        for (Integer[] next : result) {
            System.out.print(next[0] + "," + next[1] + " ");
        }

    }

    public static void main(String[] args) {
        Integer[][] intervals={{1,3},{2,6},{8,10},{15, 18}};
        merge(intervals);
    }
}
