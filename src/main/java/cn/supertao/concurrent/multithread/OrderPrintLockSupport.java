package cn.supertao.concurrent.multithread;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author shidt
 * @date 2021/4/12 9:56
 */
public class OrderPrintLockSupport {

    private Thread tA, tB, tC;

    @Test
    public void lockSupportResolve() {
        int N = 5;

        tA = new Thread(() -> {
            int n = N;
            while (n >0) {
                System.out.println("A");
                n--;
                LockSupport.unpark(tB);
                LockSupport.park();
            }
        });

        tB = new Thread(() -> {
            int n = N;
            while (n > 0) {
                LockSupport.park();
                System.out.println("B");
                n--;
                LockSupport.unpark(tC);
            }

        });

        tC = new Thread(() -> {
            int n = N;
            while (n > 0) {
                LockSupport.park();
                System.out.println("C");
                System.out.println("\n");
                n--;
                LockSupport.unpark(tA);
            }
        });

        tA.start();
        tB.start();
        tC.start();
    }
}
