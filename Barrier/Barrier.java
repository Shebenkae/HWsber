package Barrier;

public class Barrier {
    private final int maxTreadCount;
    private int currentThreadCount;

    public Barrier(int maxTreadCount) {
        this.maxTreadCount = maxTreadCount;
        currentThreadCount = 0;
    }

    public synchronized void await() {
        this.currentThreadCount++;
        if (currentThreadCount >= maxTreadCount) {
            notifyAll();
            return;
        }
        while (this.currentThreadCount < this.maxTreadCount) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

        }
    }
}
