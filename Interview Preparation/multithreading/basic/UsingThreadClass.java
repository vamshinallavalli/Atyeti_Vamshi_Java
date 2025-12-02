package basic;

public class UsingThreadClass extends Thread{
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            System.out.println(i+" Printing using"+Thread.currentThread().getName());
        }


        System.out.println("====================================================");

        UsingThreadClass t=new UsingThreadClass();
        t.start();
    }

    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(i+" Printing using"+Thread.currentThread().getName());
        }
    }
}
