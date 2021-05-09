package cn.supertao.limiter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    private volatile static Map<String, LinkedList<Long>> map = new ConcurrentHashMap<>();


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
        return Boolean.TRUE;
    }

    /**
     *
     * TODO 未必完善
     * @param id
     * @param count
     * @param timeWindow 毫秒
     * @return
     */
    public static boolean acquire(String id, int count, long timeWindow) {
        final long now = System.currentTimeMillis();
        final LinkedList<Long> list = map.computeIfAbsent(id, k -> new LinkedList<>());
        if (list.size() < count) {
            list.addFirst(now);
            return Boolean.TRUE;
        }
        final Long farTime = list.getLast();

        if (now -farTime <= timeWindow) {
            return false;
        } else {
            list.removeLast();
            list.addFirst(now);
            return true;
        }

    }


    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(20);

        final Random random = new Random();

        final SmoothLimiter limiter = new SmoothLimiter(5L);
        for (int i = 0; i < 1000; i++) {
            service.submit(() -> {
                final boolean b = acquire("list", 3, 10 * 1000L);
                System.out.println(LocalDateTime.now().toString() + " "+  b);
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        service.shutdown();
    }

}
