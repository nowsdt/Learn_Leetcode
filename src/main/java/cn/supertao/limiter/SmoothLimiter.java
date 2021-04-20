package cn.supertao.limiter;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shidt
 * @date 2021/4/20 15:28
 */
public class SmoothLimiter extends Limiter{
    /**
     * qps
     */
    private final long qps;
    private final int spilt = 10;
    private volatile int index = 0;
    private final long[] counters = new long[spilt];
    private final ReentrantLock lock = new ReentrantLock();

    public SmoothLimiter(Long qps) {
        this.qps = qps;
    }

    /**
     * TODO 可能不对
     *
     * @return
     */
    @Override
    public boolean  tryAcquire() {
        lock.lock();
        slideWindow();
        final long count = Arrays.stream(counters).sum();
        lock.unlock();
        if (count >= qps) {
            return false;
        } else {
            counters[index]++;
            return true;
        }

    }

    private void slideWindow() {
        for (int i = 0; i < spilt; i++) {
            System.out.println("index0: " + index);
            index = (index + 1) % spilt;
            System.out.println("index1: " + index);
            System.out.println("============");
            counters[index] = 0;
        }
        System.out.println();
        System.out.println(Arrays.toString(counters));
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(20);

        final SmoothLimiter limiter = new SmoothLimiter(5L);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                final boolean b = limiter.tryAcquire();
                System.out.println(b);
            });
        }
    }

}
