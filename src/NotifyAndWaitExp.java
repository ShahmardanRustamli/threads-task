public class NotifyAndWaitExp {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-1 starting");
                try {
                    wait();
                    // wait deyende Threadi gozledirik..
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("Thread-1 is continue");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-2 starting");
                try {
                    Thread.sleep(5000);
                    notify();
                    // notify dedikde iste ishlemeye bashlayir
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("Thread-2 is continue");
            }
        });
    }
}
