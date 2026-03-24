
/*
Java Scenario 7: Sequential Execution of Two Threads Printing Numbers (1,2,3…) and
Letters(A,B,C,..) in Java. So that it prints (A,1,B,2…)
Hint:
 Use synchronization to ensure correct order
 */
public class Scenario7 {
    public static void main(String[] args) {
        Scenario7 obj=new Scenario7();

        Thread t1=new Thread(()->obj.odd());
        Thread t2=new Thread(()->obj.even());
    }

    private void even() {

    }

    private void odd() {
    }
}
