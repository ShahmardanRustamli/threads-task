public class Main {
    private static volatile boolean isStopped = false;
    public static void main(String[] args) {
        //Valotile`ni Atomic ile de evez ede bilerik,
        // Atomic obyektini yaradib eger .set versek Valotile`ni evez etmish olariq.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                // Valotile numunesi, deyerin ozunu oxudugu ucun burada gorub deyishe bilir.

                while (!isStopped){
                    i++;
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException exception){
            throw new RuntimeException();
        }
        isStopped = true;
        System.out.println("salam");
        // Valotile numunesi, deyerin ozunu oxudugu ucun burada gorub deyishe bilir.
    }
}
