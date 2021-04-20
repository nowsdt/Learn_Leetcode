package cn.supertao.knum;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shidt
 * @date 2021/3/31 13:39
 */
public class MinK {

    @Test
    public void testMinK() {
        int[] nums = {1,8,4,3,7};
        int minK = minK(nums, 2);
        System.out.println(minK);
    }


    public int minK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
