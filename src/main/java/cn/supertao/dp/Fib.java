package cn.supertao.dp;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author shidt
 * @date 2020/10/15 10:05
 */
public class Fib {
    private static final int N = 25;
    public static void main(String[] args) {

        final Stopwatch watch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            System.out.println("=========start===============");
            if (!watch.isRunning()) {
                watch.start();
            }
            fib1(N);
            watch.stop();
            System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));

            watch.start();
            fib2(N);
            watch.stop();
            System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));

            watch.start();
            fib3(N);
            watch.stop();
            System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));

            watch.start();
            fib4(N);
            watch.stop();
            System.out.println(watch.elapsed(TimeUnit.NANOSECONDS));

            System.out.println("=========stop===============");
        }
    }



    private static int fib1(int N) {
        if (N ==1 || N == 2) {
            return 1;
        }

        return fib1(N-1) + fib1(N - 2);
    }

    private static final int[] memo = new int[N+1];;

    private static int fib2(int N) {
        if (N ==1 || N == 2) {
            return 1;
        }

        final Integer me = memo[N];
        if (me != null) {
            return me;
        }

        final int next = fib2(N - 1) + fib2(N - 2);

        memo[N] = next;
        return next;
    }

    /**
     * 自底向上
     *
     * @param N
     * @return
     */
    private static int fib3(int N) {
        int[] dp = new int[N+1];

        dp[1] = dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    /**
     * 自底向上
     *
     * @param N
     * @return
     */
    private static int fib4(int N) {
        if (N == 2 || N == 1) {
            return 1;
        }

        int prev = 1, curr = 1;

        for (int i = 3; i <= N; i++) {
            int sum = prev + curr;

            prev = curr;
            curr = sum;
        }

        return curr;
    }
}
