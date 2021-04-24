package cn.supertao.findnum;

import org.junit.Test;

/**
 *
 *
 * @author shidt
 * @date 2021/4/21 7:04
 */
public class FindNumOnce {

    @Test
    public void test() {
        int[] num = {1,2,3,4,1,2,3};
        System.out.println(exactlyOnce(num));
    }

    /**
     * 一个整型数组里除了一个数字之外，其他的数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     *   要求时间复杂度为O(n)，空间复杂度为O(1)
     *   当前数组为 {1,2,3,4,1,2,3}，只出现一次的唯一数字是4
     *
     */
    public int exactlyOnce(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
