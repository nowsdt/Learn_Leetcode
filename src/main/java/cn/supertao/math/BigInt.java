package cn.supertao.math;

import org.junit.Test;

import java.math.BigInteger;

/**
 *
 * 大整数加法
 *
 * @author shidt
 * @date 2021/3/30 10:54
 */
public class BigInt {

    @Test
    public void testBigIntAdd() {
        String s1="15", s2 = "20";

        final String result = bigIntAdd(s1, s2);
        System.out.println(result);
        assert new BigInteger(result).equals(new BigInteger(s1).add(new BigInteger(s2)));

    }

    public String bigIntAdd(String s1, String s2) {
        final StringBuilder builder = new StringBuilder();

        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s1.charAt(i--) - '0';
            int y = j < 0 ? 0 : s2.charAt(j--) - '0';
            int sum = x + y + carry;
            builder.append(sum % 10);
            carry = sum / 10;
        }


        return builder.reverse().toString();
    }
}
