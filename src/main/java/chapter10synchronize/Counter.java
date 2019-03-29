package chapter10synchronize;

public class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }

    public synchronized void add2(long value) {
        this.count += value;
    }

    public void synField(boolean isSyn, int i, String name) {

        if (isSyn) {
            synchronized (this) {
                System.out.println(name + ": sys " + i);
            }
        } else {
            System.out.println(name + ": noSys " + i);
        }
    }
}
