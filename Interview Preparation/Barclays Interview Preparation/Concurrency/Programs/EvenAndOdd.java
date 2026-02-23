package Programs;

public class EvenAndOdd {

    int start=1;
    int limit=10;
    //boolean done;

    public static void main(String[] args) {

        EvenAndOdd obj=new EvenAndOdd();

        Thread t1=new Thread(()-> {
            try {
                obj.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2=new Thread(()-> {
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
        while(start<=limit){
            if(start%2==0){
                wait();
            }

            if(start>10)
                break;
            System.out.println("Odd: "+start);
           // done=true;
            start++;
            notify();
        }
    }

    public synchronized void odd() throws InterruptedException {
        while(start<=limit){
            if(start%2!=0){
                wait();
            }
            System.out.println("Even: "+start);
            start++;
            notify();
        }
    }
}
