package cn.supertao.limiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shidt
 * @date 2021/4/20 17:31
 */
public class TokenBucketLimiter extends Limiter {
    /**
     * 多少秒1个
     */
    private final long rate;
    private final long cap;
    /**
     * token剩余量
     */
    private AtomicLong token;

    public TokenBucketLimiter(long rate, long cap) {
        this.rate = rate;
        this.cap = cap;
        new Thread(() -> {
            while (true) {
                if (token.longValue() < cap) {
                    token.incrementAndGet();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(rate);
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }

    @Override
    public synchronized boolean tryAcquire() {
        if (token.longValue() > 0){
            token.decrementAndGet();
            return true;
        }
        return false;
    }
}
