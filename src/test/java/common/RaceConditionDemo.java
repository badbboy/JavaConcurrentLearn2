package common;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.RequestIdGenerator;

public class RaceConditionDemo {
    private static Logger logger = LoggerFactory.getLogger(RaceConditionDemo.class);
    private static RequestIdGenerator generator = RequestIdGenerator.getInstance();

    @Test
    public void test() {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        numberOfThreads = 100;
        Thread[] workThreads = new Thread[numberOfThreads];
        logger.debug("numberOfThreads: " + numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            workThreads[i] = new WorkerThread(i, 100);
        }
        for (Thread t : workThreads) {
            t.start();
        }

        //logger.debug(generator.frequency.toString());

        for (Map.Entry<Short,Integer> map : generator.frequency.entrySet()) {
            if (map.getValue() > 1) {
                logger.debug("" + map);
            }
        }
    }

    static class WorkerThread extends Thread {
        private final int requestCount;

        public WorkerThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            while (i-- > -1) {
                generator.nextSequence();
              /*  String requestId = generator.nexId();
                processRequest(requestId);*/
            }
        }

        private void processRequest(String requestId) {
            logger.debug(Thread.currentThread().getName() + " " + requestId);
            //try {
            //    Thread.currentThread().sleep(1L);
            //} catch (Exception e) {
            //    logger.error(e.getMessage());
            //}

        }
    }

}
