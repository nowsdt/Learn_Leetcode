package cn.supertao.concurrent.multithread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shidt
 * @date 2021/4/12 9:56
 */
public class OrderPrintLock {
    private final ReentrantLock lock = new ReentrantLock();
    private int times;
    private int state;

    public OrderPrintLock(int times) {
        this.times = times;
        this.state = 0;
    }

    public OrderPrintLock() {
    }

    private void print(String name, int target) {
        for (int i = 0; i < times;) {
            lock.lock();
            if (state % 3 == target) {
                state++;
                i++;
                System.out.println("thread:" + Thread.currentThread().getName() + ": "  + name);

                if (target == 2) {
                    System.out.println();
                }
            }
            lock.unlock();
        }
    }

    @Test
    public void testResolve() {
        final OrderPrintLock printLock = new OrderPrintLock(3);
        new Thread(() -> printLock.print("B", 1), "B").start();
        new Thread(() -> printLock.print("A", 0), "A").start();
        new Thread(() -> printLock.print("C", 2), "C").start();
    }
}
