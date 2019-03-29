package chapter10synchronize;

public class Example {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter,"A");
        Thread threadA2 = new CounterThread2(counter,"A2");
        Thread threadB = new CounterThread(counter,"B");
        Thread threadC = new CounterThread(new Counter(),"C");
        Thread threadD = new CounterThread(new Counter(),"D");

        threadA.start();
        threadA2.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

}
