

 public class DiffBetweenRunStart extends Thread {
    public void run() {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        DiffBetweenRunStart t = new DiffBetweenRunStart();
        t.run();    // ❌ no new thread
        t.start();  // ✅ new thread
    }
}

