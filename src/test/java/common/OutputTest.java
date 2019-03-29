package common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.RequestIdGenerator;

public class OutputTest {
    Logger logger = LoggerFactory.getLogger(OutputTest.class);


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }

/*
        ThreadConsume threadConsume = new ThreadConsume();
        threadConsume.testCreateHundredThread();*/

    }

    @Test
    public void testRequestIdGenerator() {
        RequestIdGenerator requestIdGenerator = RequestIdGenerator.getInstance();
        String timeStamp = requestIdGenerator.nexId();

        logger.trace(timeStamp);
        logger.debug(timeStamp);
        logger.info(timeStamp);
        logger.warn(timeStamp);
        logger.error(timeStamp);

    }
}
