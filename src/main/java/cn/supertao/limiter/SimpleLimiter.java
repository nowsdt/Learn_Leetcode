package cn.supertao.limiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shidt
 * @date 2021/4/20 15:28
 */
public class SimpleLimiter extends Limiter{
    /**
     * qps
     */
    private final Long qps;
    /**
     * 当前
     */
    private final AtomicLong count = new AtomicLong(0);

    public SimpleLimiter(Long qps, Integer winSize) {
        this.qps = qps;
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(winSize);
                    count.set(0L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    boolean tryAcquire() {
        final long cur = count.addAndGet(1L);
        return cur < qps;
    }
}
