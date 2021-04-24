package cn.supertao.findnum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shidt
 * @date 2021/4/21 6:50
 */
public class FindSeries {

    @Test
    public void test() {
        int[] nums = {1,2,3,5,7};
        List<Integer> result = findMiss(nums, 7);
        System.out.println(result);
    }

    /**
     * 1-n有序数字中连续有序数据找到丢失的
     *
     *  input:1,2,3,5,7
     *  output:4,6
     * @param arr
     * @return
     */
    public List<Integer> findMiss(int[] arr, int N) {
        if (arr == null || arr.length == 0) return null;
        int[] b = new int[N+1];

        for (int i : arr) {
            b[i] = 1;
        }

        List<Integer> result = new ArrayList<>(arr.length >> 2);

        for (int i = 1; i < b.length; i++) {
            if (b[i] == 0) {
                result.add(i);
            }
        }

        return result;

    }

}
