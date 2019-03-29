package chapter10synchronize;

public class CounterThread extends Thread {
    protected Counter counter = null;
    private String name;

    public CounterThread(Counter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           /* counter.add(i);
            System.out.println(name +" "+ counter.count);*/
            counter.synField(true, i,name);
        }
    }
}
