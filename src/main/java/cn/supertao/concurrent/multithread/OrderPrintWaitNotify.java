package cn.supertao.concurrent.multithread;

import org.junit.Test;

/**
 * @author shidt
 * @date 2021/4/12 9:56
 */
public class OrderPrintWaitNotify {
    private final Object lock = new Object();
    private int times;
    private int state;

    public OrderPrintWaitNotify(int times) {
        this.times = times;
        this.state = 0;
    }

    public OrderPrintWaitNotify() {
    }

    private void print(String name, int target) {
        for (int i = 0; i < times; ) {
            synchronized (lock) {
                while (state % 3 != target) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                state++;
                i++;
                System.out.println("thread:" + Thread.currentThread().getName() + ": " + name);

                if (target == 2) {
                    System.out.println();
                }
                lock.notifyAll();

            }
        }
    }

    @Test
    public void testResolve() {

    }


    public static void main(String[] args) {
        final OrderPrintWaitNotify printLock = new OrderPrintWaitNotify(3);
        new Thread(() -> printLock.print("B", 1), "B").start();
        new Thread(() -> printLock.print("A", 0), "A").start();
        new Thread(() -> printLock.print("C", 2), "C").start();
    }
}
