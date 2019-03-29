package chapter11signal;

public class MyWaitNotify {
    MonitorObject monitorObject = new MonitorObject();

    public void doWait() {
        synchronized (monitorObject) {
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {

            }
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }
}
