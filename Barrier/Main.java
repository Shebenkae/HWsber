package Barrier;

public class Main {
    private static final Barrier barrier = new Barrier(3);

    public static void main(String[] args) {


        Main main = new Main();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> main.runBarrier()).start();
        }
    }

    public void runBarrier() {
        doRun();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barrier.await();
    }

    private  void doRun() {
        System.out.println("newThread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
