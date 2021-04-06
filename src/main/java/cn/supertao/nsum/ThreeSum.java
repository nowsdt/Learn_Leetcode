package cn.supertao.nsum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shidt
 * @date 2021/4/6 10:54
 */
public class ThreeSum {

    @Test
    public void testTwoSum() {
        threeSum(new int[]{2,1,3,4,5,7,6,8}, 10);
    }


    public void threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final List<List<Integer>> twoSum = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> list : twoSum) {
                list.add(nums[i]);
                result.add(list);
            }
            while (i < n-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        System.out.println(result);

    }


    public List<List<Integer>> twoSum(int[] nums, int start,  int target) {

        int lo = start, hi = nums.length - 1;


        List<List<Integer>> twoResult = new ArrayList<>();
        while (lo < hi) {
            final int sum = nums[lo] + nums[hi];
            if (sum < target) lo++;
            if (sum > target) hi--;

            if (sum == target) {
                final int left = nums[lo];
                final int right = nums[hi];
                twoResult.add(Stream.of(left, right).collect(Collectors.toList()));
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }

        return twoResult;
    }
}
