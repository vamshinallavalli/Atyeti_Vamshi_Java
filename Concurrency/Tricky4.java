
    class Tricky4 extends Thread {
        public void run() {
            System.out.print("T");
        }

        public static void main(String[] args) throws Exception {
            Tricky4 t = new Tricky4();
            t.start();
            t.join();
            System.out.print("M");
        }
    }

