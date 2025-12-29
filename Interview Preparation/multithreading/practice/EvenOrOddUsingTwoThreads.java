package practice;

class EvenOrOddUsingTwoThreads extends Thread{
    int num=1;
    public static void main(String[] args) {

        EvenOrOddUsingTwoThreads obj=new EvenOrOddUsingTwoThreads();

        Thread t1=new Thread(()->{

            try {
                obj.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2=new Thread(()->{
            try {
                obj.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        t1.start();
        t2.start();



    }

    public synchronized void even() throws InterruptedException {
        while(num<=10){
            if(num%2!=0) wait();
            System.out.println("Even: "+num++);
            notify();
        }
    }

    public synchronized void odd() throws InterruptedException {
        while(num<=10){
            if(num%2==0) wait();
            System.out.println("Odd: "+num++);
            notify();
        }
    }
}