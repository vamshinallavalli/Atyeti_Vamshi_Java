public class ThreadExample {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread Started Running........");
    }
}
