public class RunnableExample {
    public static void main(String[] args) {

        MyThreadR t=new MyThreadR();

        Thread thread=new Thread(t);

        thread.start();
    }
}

class MyThreadR implements Runnable{
    public void run(){
        System.out.println("Thread Started by Runnable");
    }
}