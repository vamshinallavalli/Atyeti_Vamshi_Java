package basic;

public class UsingRunnableInterface implements Runnable{
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            System.out.println(i+" Printing using"+Thread.currentThread().getName());
        }


        System.out.println("====================================================");

        UsingRunnableInterface r=new UsingRunnableInterface();
        Thread t=new Thread(r);
        t.start();
    }

    @Override
    public void run() {
        for(int i=0;i<=5;i++){
            System.out.println(i+" Printing using"+Thread.currentThread().getName());
        }
    }
}
