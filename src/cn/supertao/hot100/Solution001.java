package cn.supertao.hot100;

import cn.supertao.utils.MapUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author shidt
 * @date 2019/8/5 13:23
 */
public class Solution001 {
    public static void main(String[] args) {
        final Integer[] array = Arrays.asList(12, 15, 18, 2, 5, 7).toArray(new Integer[1]);
        final int[] twoSum = twoSum1(array, 19);
        System.out.println(Arrays.toString(twoSum));

    }

    public static int[] twoSum0(Integer[] nums, int target) {
        final HashMap<Integer, Integer> hashMap = MapUtils.newHashMapWithExpectedSize(nums.length);

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }


        for (int i = 0; i < nums.length; i++) {
            final int j = target - nums[i];
            if (hashMap.containsKey(j) && j != nums[i]) {
                return new int[]{i, hashMap.get(j)};
            }
        }
        return null;
    }

    public static int[] twoSum1(Integer[] nums, int target) {
        final HashMap<Integer, Integer> hashMap = MapUtils.newHashMapWithExpectedSize(nums.length);

        for (int i = 0; i < nums.length; i++) {
            final int j = target - nums[i];
            if (hashMap.containsKey(j) && j != nums[i]) {
                return new int[]{i, hashMap.get(j)};
            }

            hashMap.put(nums[i], i);
        }

        return null;
    }
}
