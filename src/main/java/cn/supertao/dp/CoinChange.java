package cn.supertao.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shidt
 * @date 2020/11/29 21:43
 */
public class CoinChange {
    private static int[] coins;
    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 17;

        change1(coins, amount);
        change2(coins, amount);
        change3(coins, amount);
        System.out.println(memo);
        System.out.println("coder change the world");
    }

    /**
     * 自顶向下
     *
     * @param coins
     * @param amount
     */
    public static void change1(int[] coins, int amount) {
        CoinChange.coins = coins;
        final int cnt = dp1(amount);
        System.out.println("change1 :" + cnt);
    }

    private static int dp1(int amount) {
        if (amount == 0) {
            return 0;
        }
        // 无解
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cnt = dp1(amount - coin);
            if (cnt == -1 ) {
                continue;
            }
            result = Math.min(result, cnt + 1);
        }
        return result == Integer.MAX_VALUE? -1: result;
    }

    /**
     * 自顶向下 带备忘录
     *
     * @param coins
     * @param amount
     */
    public static void change2(int[] coins, int amount) {
        CoinChange.coins = coins;
        final int cnt = dp2(amount);
        System.out.println("change2 :" + cnt);
    }

    private static int dp2(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        final Integer tmp = memo.get(amount);
        if (tmp != null) {
            return tmp;
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cnt = dp2(amount - coin);

            if (cnt == -1) {
                continue;
            }

            result = Math.min(result, cnt + 1);

        }
        final int tmpResult = result == Integer.MAX_VALUE ? -1 : result;
        memo.put(amount , result);
        return tmpResult;

    }

    /**
     * 自底向上
     * dp 数组的定义：当目标金额为 i 时，至多需要 dp[i] 枚硬币凑出
     *
     * @param coins
     * @param amount
     */
    public static int change3(int[] coins, int amount) {
        CoinChange.coins = coins;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount);


        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        final int result = dp[amount] == amount + 1 ? -1 : dp[amount];
        System.out.println("change3 :" + result);
        return result;
    }
}
