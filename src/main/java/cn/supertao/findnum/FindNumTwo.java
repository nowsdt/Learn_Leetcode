package cn.supertao.findnum;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 *
 * @author shidt
 * @date 2021/4/21 7:04
 */
public class FindNumTwo {

    @Test
    public void test() {
        int[] num = {1,2,3,4,5,1,2,3,4,6};
        int[] two = findTwo(num);
        System.out.println(Arrays.toString(two));
    }


    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     *
     * 要求时间复杂度为O(n)，空间复杂度为O(1)
     *
     * input: {1,2,3,4,1,2,3,4,5,6}
     * output: {5,6}
     *
     * 第二个题目，在原来的基础上，多了一个只出现一次的数字，
     * 实际这个题目也是根据异或的性质来求解。可以把当前的数组看成两个数组，
     * 其中每一个数组都只包含一个出现一次的数字，其他的数字都出现了两次。
     * 即如下图所示（只是举例，没有实际意义），上面的数组可以拆分成下面的两个小数组。
     * https://mmbiz.qpic.cn/mmbiz_png/gH6pZ2bAHibh455FqIBWjKIpGlgGnxDRSlXTEMbRrPPbU15sSUvibjqlyfFfC8bw3dibaanJL12TxQeK9GTibpGzGA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1
     * 一旦拆分成两个小数组，就可以通过异或的方式分别求出出现一次的数字。所以问题就变成了如何拆分成两个数组。
     *
     *
     *
     * 如果直接对整个数组的所有元素进行异或会出现什么结果呢？拿上面的数组举例，
     * 相同的数字异或的结果为0，实际的表达式就变成了了 5 ^ 6 。
     * 因为这两个数字一定不一样，所以异或的结果不为0，即异或最终的结果一定在二进制的某一位上是为1的
     *
     * 所以只要能在异或的结果中找到从最低位到最高位第一个为1的位置（区分开两个数组），
     * 就可以把数组根据这个位置是否为1（出现两次互相抵消）把数组分成两个小数组。每个小数组只包含一个只出现一次的数字。
     * 最后再分别异或这两个数组，就可以得到两个唯一的数字
     *
     *
     *
     *
     * @param nums
     * @return
     */
    public int[] findTwo(int[] nums) {
        int tmp = 0;
        for (int num : nums) {
            tmp ^= num;
        }

        int index = findFirstOne(tmp);
        System.out.println(index);

        int first = 0, second = 0;
        for (int num : nums) {
            if (((num >> index) & 1) ==1) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[]{first, second};
    }

    /**
     * 从低位到高位找到第一个是0的位数
     *
     * @param num
     * @return
     */
    private int findFirstOne(int num) {
        int idx = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (((num >> i) & 1) == 1) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
