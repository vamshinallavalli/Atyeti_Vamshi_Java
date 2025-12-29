package practice;

public class UsingRunnable {
    public static void main(String[] args) {

        Runnable runnable=()->{
            System.out.println("Hello");
        };

        Thread t=new Thread(runnable);
        t.start();
    }
}
