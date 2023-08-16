public class DeadLockExample {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        // Hal-hazirda bu proqramimiz deadlock veziyyetindedir,
        // 2 Thread biri birine muraciet edir ve ikisi de biri birini gozleyir
        // buna gore de deadlock prosesi bash verir, bunun helli yoxdur.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is waiting for:"+ lock1);
                synchronized (lock1){
                    System.out.println("Thread2 is waiting for:"+ lock2);
                    synchronized (lock2){
                        System.out.println("Thread1");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is waiting for:"+ lock2);
                synchronized (lock2){
                    System.out.println("Thread2 is waiting for:"+ lock1);
                    synchronized (lock1){
                        System.out.println("Thread1");
                    }
                }
            }
        });
        thread.start();
        thread2.start();
    }
}
