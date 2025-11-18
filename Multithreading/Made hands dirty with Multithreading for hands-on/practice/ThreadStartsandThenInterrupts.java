public class ThreadStartsandThenInterrupts {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            try {
                System.out.println("Running...");
                while (true) {
                    // Simulate work
                    Thread.sleep(1000);
                    System.out.println("Working...");
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });


        t.start();

        try{
            Thread.sleep(3000);
            System.out.println("Now just Completed and interrupting now");
            t.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}