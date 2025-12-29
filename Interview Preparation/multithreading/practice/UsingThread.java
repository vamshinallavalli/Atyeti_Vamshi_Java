package practice;

public class UsingThread {
    public static void main(String[] args) {

        Runnable t=()->{
            System.out.println("Hello....");
        };

        Thread t1=new Thread(t);

        t1.start();

    }
}
