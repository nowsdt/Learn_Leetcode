package cn.supertao.multithread;

/**
 * @author shidt
 * @date 2021/4/12 11:36
 */
public class OddEvenPrint {
    private int times;
    private volatile int count;
    private final Object monitor = new Object();


    public OddEvenPrint() {
    }

    public OddEvenPrint(int times, int count) {
        this.times = times;
        this.count = count;
    }

    public void print() {
        synchronized (monitor) {
            while (count < times) {
                System.out.println("thread:" + Thread.currentThread().getName() + " " + (++count));
                monitor.notifyAll();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notifyAll();
        }

    }


    public static void main(String[] args) {
        final OddEvenPrint oddEvenPrint = new OddEvenPrint(10, 0);

        new Thread(oddEvenPrint::print, "even").start();
        new Thread(oddEvenPrint::print, "odd").start();
    }
}
