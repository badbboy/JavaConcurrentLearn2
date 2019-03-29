package chapter10synchronize;

public class CounterThread2 extends Thread {
    protected Counter counter = null;
    private String name;

    public CounterThread2(Counter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           /* counter.add2(i);
            System.out.println(name +"2 "+ counter.count);*/
            counter.synField(false, i, name);
        }
    }
}
