package cn.supertao.limiter;

/**
 * @author shidt
 * @date 2021/4/20 17:31
 */
public class LeakBucketLimiter extends Limiter {
    private final long rate;
    private final long cap;
    private long water;
    private long start = System.currentTimeMillis();

    public LeakBucketLimiter(long rate) {
        this.rate = rate;
        this.cap = rate;
    }

    @Override
    public synchronized boolean tryAcquire() {
        final long now = System.currentTimeMillis();
        final long remain = Math.max(0, water - (now - start) * rate);
        if (remain + 1 < cap){
            water++;
            return true;
        }
        return false;
    }
}
