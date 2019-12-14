package java.hw.semaphore;

public class SemMain {

    private final SemaphoreImpl semaphore = new SemaphoreImpl(4);

    public static void main(String[] args) {
        SemMain main = new SemMain();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> main.run()).start();
        }
    }

    public void run() {
        semaphore.lock();
        try {
            doRun();
        } finally {
            semaphore.unlock();
        }
    }

    private void doRun() {
        System.out.println("Before");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
