public class MyThread implements Runnable {
    // Bu klassi eger Threads`dan extends elesek elave olaraq .start() methodunu goreceyik.

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Test:" + i);
        }
    }

}
