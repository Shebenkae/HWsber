package java.hw.semaphore;

public class SemaphoreImpl {
    private int treadCount = 0;
    private int max ;

    public SemaphoreImpl(int max) {
        this.max = max;
    }

    public void lock() {
        synchronized (this){
            while (treadCount >= max) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ++treadCount;
        }
    }

    public void unlock() {
        synchronized (this){
            treadCount--;
            this.notify();
        }
    }
}
