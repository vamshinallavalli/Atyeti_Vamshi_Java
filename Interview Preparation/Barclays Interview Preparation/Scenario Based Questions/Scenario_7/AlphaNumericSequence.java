package Scenario_7;
/*
Sequential Execution of Two Threads Printing Numbers (1,2,3…) and Letters(A,B,C,..) in Java. So that it prints (A,1B,2…)

Hint:  Use synchronization to ensure correct order

 */
class AlphaNumericSequence{
    static int start=1;
    static int end=26;
    static char begin='A';
    static boolean isAlphabet=true;

    public static void main(String[] args) {

        AlphaNumericSequence object=new AlphaNumericSequence();

        Thread t1=new Thread(()-> {
            try {
                object.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2=new Thread(()-> {
            try {
                object.alphabet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }

    private synchronized void alphabet() throws InterruptedException {
        while (begin<='Z'){
            if(!isAlphabet){
                wait();
            }else{
                System.out.print(begin+",");
                begin++;
                isAlphabet=false;
                notifyAll();
            }
        }
    }

    private synchronized void number() throws InterruptedException {
        while (start<=end){

                if (isAlphabet) {
                    wait();
                } else {
                    System.out.print(start + ",");
                    start++;
                    isAlphabet = true;
                    notifyAll();
                }

        }
    }
}