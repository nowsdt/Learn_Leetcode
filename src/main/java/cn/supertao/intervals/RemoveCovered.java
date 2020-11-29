package cn.supertao.intervals;

import java.util.Arrays;

/**
 *
 * 移除重复区间
 *
 * @author shidt
 * @date 2020/11/7 14:52
 */
public class RemoveCovered {

    // intervals = [[1,4],[3,6],[2,8]]
    // [3,6] 被[2,8]覆盖  所以被删除了
    // 输出剩余区间个数

    public static void remove(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] -o1[1];
            }
            return o1[0] - o2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;


        for (int i = 1; i < intervals.length; i++) {
            final int[] interval = intervals[i];
        //     重合
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            }
        //    相交
            if (right >= interval[0] && right < interval[1]) {
                right = interval[1];
            }

            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];

            }
        }

        System.out.println("剩余区间数:" + (intervals.length - res));
    }

    public static void main(String[] args) {
        int[][] intervals={{1,4},{3,6},{3,4},{2,8}, {3,7}, {3, 9}};

        remove(intervals);
    }
}
