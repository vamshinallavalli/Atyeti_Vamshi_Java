public class NullAmbiguity {
        void m(String s) {
            System.out.println("String");
        }

        void m(Object o) {
            System.out.println("Object");
        }

        public static void main(String[] args) {
            NullAmbiguity t = new NullAmbiguity();
            t.m(null);
        }
    }

