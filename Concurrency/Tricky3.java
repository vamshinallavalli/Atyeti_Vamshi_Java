


    class Tricky3 extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }

        public static void main(String[] args) {
            Tricky3 t = new Tricky3();
            t.run();
        }
    }

