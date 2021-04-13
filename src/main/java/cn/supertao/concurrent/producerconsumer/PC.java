package cn.supertao.concurrent.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shidt
 * @date 2021/4/12 16:39
 */
public class PC {
    private String[] container;
    private volatile int size;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public PC(String[] container) {
        this.container = container;
        this.size = container.length;
    }

    public void produce()  {
        lock.lock();
        // 满了
        while (size == container.length) {
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int c = size++;
        System.out.println("生产 t: " + Thread.currentThread().getName() + " " + size);

        if (c <= 0) {
            empty.signal();
        }


        lock.unlock();
    }

    public void consume() {
        lock.lock();
        // 满了
        while (size == 0) {
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int c = size--;
        System.out.println("消费 t: " + Thread.currentThread().getName() +" " + size);

        if (c == container.length) {
            full.signal();
        }

        lock.unlock();
    }

    public static void main(String[] args) {
        final PC pc = new PC(new String[1]);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    pc.produce();
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    pc.consume();
                }
            }).start();
        }
    }

}
