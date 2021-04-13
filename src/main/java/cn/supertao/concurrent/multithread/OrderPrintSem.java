package cn.supertao.concurrent.multithread;

import java.util.concurrent.Semaphore;

/**
 * @author shidt
 * @date 2021/4/12 17:04
 */
public class OrderPrintSem {
    private int times;

    private static final Semaphore a = new Semaphore(1);
    private static final Semaphore b = new Semaphore(0);
    private static final Semaphore c = new Semaphore(0);

    public OrderPrintSem(int times) {
        this.times = times;
    }

    public void print(String name, Semaphore cur, Semaphore nxt) {
        for (int i = 0; i < times; i++) {
            try {
                cur.acquire();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name);
            if ("C".equals(name)) {
                System.out.println();
            }
            nxt.release();
        }
    }

    public static void main(String[] args) {
        final OrderPrintSem printSem = new OrderPrintSem(10);
        new Thread(() -> printSem.print("A", a, b)).start();
        new Thread(() -> printSem.print("B", b, c)).start();
        new Thread(() -> printSem.print("C", c, a)).start();
    }
}
