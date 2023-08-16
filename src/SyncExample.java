public class SyncExample {
    private static int count;
//    public static synchronized void increment(){
//        count++;
//     synchronized dedikde methoda giris bloklanir ve threadlar novbeli shekilde girmeli olur methoda.
//    }

    public void increment(){
        synchronized (this){
            count++;
            // Buna monitor anlayishi deyilir,emeliyyata muracieti kilitleyirik..
            // eyni zamanda da umumi adla lock deye bilerik.
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        });
        try {
            thread.start();
            thread.join();
            thread2.start();
            thread2.join();
            //start ve join ve run ferqi,
            // join -  etdikde threadi blokladib gozledir
            //  start -  etdikde eyni anda paralel ishe bashlayirlar.
            // run - ise normal qaydada novbeli sekilde yuxaridan asagi solda saga oxuyur.
        }catch (InterruptedException ex){
            throw new RuntimeException();
        }


        System.out.println("Count:"+count);
    }
}
