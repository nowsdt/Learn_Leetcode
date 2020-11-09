package cn.supertao.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * 查找区间交集
 *
 * @author shidt
 * @date 2020/11/8 18:23
 */
public class IntervalIntersection {


    public static void extend(Integer[][] intervals1, Integer[][] intervals2) {
        int i = 0,j = 0;
        LinkedList<Integer[]> result = new LinkedList<>();

        while (i < intervals1.length && j< intervals2.length) {
            int a0 = intervals1[i][0];
            int a1 = intervals1[i][1];

            int b0 = intervals2[j][0];
            int b1 = intervals2[j][1];
            // 无交集情况 a1< b0 or b1 <a0
            // 反之 交集
            if (a1 >= b0 && b1 >= a0) {
                result.add(new Integer[]{Math.max(a0,b0), Math.min(a1, b1)});
            }

            if (a1 > b1) {
                j++;
            } else {
                i++;
            }
        }

        for (Integer[] next : result) {
            System.out.print(next[0] + "," + next[1] + " ");
        }


    }

    /**
     *
     * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interval-list-intersections
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[][] intervals0={{0, 2},{5, 10},{13, 23},{24, 25}};
        Integer[][] intervals1={{1 ,5},{8, 12},{15, 24},{25, 26}};
        extend(intervals0, intervals1);
    }
}
