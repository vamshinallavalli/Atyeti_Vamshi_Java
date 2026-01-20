package Scenario_7;

public class AlphaNumericSequenceUsingObjectLock {
    private static final int limit=26;
     static boolean isLetter=false;
    private static final Object monitor=new Object();

    public static void main(String[] args) {

        AlphaNumericSequenceUsingObjectLock object=new AlphaNumericSequenceUsingObjectLock();
        Thread t1=new Thread(()-> {
            for (char ch='A'; ch <='Z';ch++){

                synchronized (monitor){
                    while (isLetter) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                        System.out.print(ch+",");
                        isLetter=true;
                        monitor.notify();

                }

            }
        });
        Thread t2=new Thread(()-> {
            for (int i=1;i<=limit;i++){
                synchronized (monitor){
                    while(!isLetter){
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                        System.out.print(i+",");
                        isLetter=false;
                        monitor.notify();

                }
            }
        });

        t1.start();
        t2.start();
    }
}
