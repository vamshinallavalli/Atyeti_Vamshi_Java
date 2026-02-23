public class IntegerVsdouble {
        void m(double d) {
            System.out.println("double");
        }

        void m(Integer i) {
            System.out.println("Integer");
        }

        public static void main(String[] args) {
            IntegerVsdouble t = new IntegerVsdouble();
            t.m(10);
        }
    }

