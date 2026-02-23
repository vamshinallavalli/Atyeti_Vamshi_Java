

class Tricky1 extends Thread {
    public void run() {
        System.out.print("A");
        try { Thread.sleep(10); } catch(Exception e){}
        System.out.print("B");
    }

    public static void main(String[] args) {
        Tricky1 t = new Tricky1();
        t.start();
        System.out.print("C");
    }
}
