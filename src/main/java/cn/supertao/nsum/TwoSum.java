package cn.supertao.nsum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shidt
 * @date 2021/4/6 10:54
 */
public class TwoSum {
    private final List<Integer[]> result = new ArrayList<>();

    @Test
    public void testTwoSum() {
        twoSum(new int[]{2,1,3,4}, 7);
        result.forEach(r -> System.out.println(Arrays.toString(r)));
    }


    public void twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            final int sum = nums[lo] + nums[hi];
            if (sum < target) lo++;
            if (sum > target) hi--;

            if (sum == target) {
                final int left = nums[lo];
                final int right = nums[hi];
                result.add(new Integer[]{left, right});
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
    }
}
