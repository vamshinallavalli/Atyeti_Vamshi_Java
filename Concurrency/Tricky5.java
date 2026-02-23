
    class Test {
        synchronized static void display() {
            System.out.print("A");
            try { Thread.sleep(100); } catch(Exception e){}
            System.out.print("B");
        }
    }

    public class Tricky5 {
        public static void main(String[] args) {
            new Thread(() -> Test.display()).start();
            new Thread(() -> Test.display()).start();
        }
    }
