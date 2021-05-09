package cn.supertao;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shidt
 * @date 2021/5/8 9:54
 */
public class TwoSum {

    @Test
    public void test() {
        int[] nums = {1,2,3,5};
        final int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }

    private int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0, len = numbers.length; i< len; i++) {

            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return null;

    }
}
