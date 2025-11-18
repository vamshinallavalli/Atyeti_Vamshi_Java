class PrintEvenOdd{

    static int count=1;
    int limit=10;

    public static void main(String[] args) {


        PrintEvenOdd obj=new PrintEvenOdd();

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

    synchronized void odd() throws InterruptedException {
        while(count<=limit){
            if(count%2==0){
                wait();
                if(count>limit) return;
            }
            System.out.println("Odd: "+count);
            count++;
            notify();
        }
    }

    synchronized void even() throws InterruptedException {
        while(count<=limit){
            if(count%2!=0){
                wait();
                if(count>limit) return;
            }
            System.out.println("Even: "+count);
            count++;
            notify();
        }
    }
}