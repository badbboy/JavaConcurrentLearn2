package common;

import org.junit.Test;

public class ThreadConsume {

    @Test
    public void testCreateHundredThread() {
        for (int i = 0; i < 100; i++) {
            new Thread(new TestThread()).start();
        }
    }
}

class TestThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread());
                wait();
            } catch (Exception e) {
                //throw new RuntimeException(e);
            }
        }
    }
}
