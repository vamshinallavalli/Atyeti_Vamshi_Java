class CreatingDeadLock{
    public static void main(String[] args) {

        final Object lock1=new Object();
        final Object lock2=new Object();

        Thread t1=new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread-1 Acquired Lock 1");


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread-1 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread-1: locked lock2");
                }
            }
        });


        Thread t2=new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread-2 Acquired Lock 1");


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread-2 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread-2: locked lock2");
                }
            }
        });


    }
}