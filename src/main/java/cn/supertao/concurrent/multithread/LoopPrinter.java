package cn.supertao.concurrent.multithread;

import java.util.concurrent.Semaphore;

/**
 * @author shidt
 * @date 2021/4/12 17:33
 */
public class LoopPrinter {
    private static final int THREAD_COUNT = 3;
    static int result = 1;
    static int maxNum = 9;

    public static void main(String[] args) {
        final Semaphore[] semaphores = new Semaphore[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT ; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != THREAD_COUNT -1) {
                try {
                    semaphores[i].acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            final Semaphore lastSemaphore = (i == 0)? semaphores[THREAD_COUNT - 1] : semaphores[i -1];
            final Semaphore curSemaphore = semaphores[i];
            final int index  = i;

            new Thread(() -> {
                while (true) {
                    try {
                        lastSemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread:" + index + ":" + (result++));
                    if (result > maxNum) {
                        System.exit(0);
                    }

                    curSemaphore.release();
                }
            }).start();
        }
    }
}
