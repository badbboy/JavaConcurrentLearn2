package chapter11signal;

public class MySignal {
    protected boolean hasDataToProcess = false;

    public synchronized boolean checkData() {
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
