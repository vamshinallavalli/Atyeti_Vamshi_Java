package basic;

public class ThreadCreation extends Thread{
    public static void main(String[] args) {
        ThreadCreation t=new ThreadCreation();
        t.start();
    }

    @Override
    public void run(){
        System.out.println("Using Thread! "+Thread.currentThread().getName());
    }
}
