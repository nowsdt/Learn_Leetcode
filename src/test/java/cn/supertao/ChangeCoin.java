package cn.supertao;

import org.junit.Test;

/**
 * @author shidt
 * @date 2021/4/7 7:39
 */
public class ChangeCoin {
    @Test
    public void testChangeCoin() {
        int coin = changeCoin(new int[]{1, 2, 3,5}, 5);
        System.out.println(coin);
    }

    private int changeCoin(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int count = Integer.MAX_VALUE;
        for (int value : coins) {
            int coin = changeCoin(coins, amount - value);
            if (coin == -1) continue;
            count = Math.min(count, 1 + coin);
        }
        return count;
    }
}
