

public class Tricky2 extends Thread {
        public void run() {
            System.out.println("Running");
        }

        public static void main(String[] args) {
            Tricky2 t = new Tricky2();
            t.start();
            t.start();
        }
    }

