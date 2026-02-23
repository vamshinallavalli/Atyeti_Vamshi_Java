public class ObjectVsPrimitive {
        void m(Object o) {
            System.out.println("Object");
        }

        void m(Integer i) {
            System.out.println("Integer");
        }

        public static void main(String[] args) {
            ObjectVsPrimitive t = new ObjectVsPrimitive();
            t.m(10);
        }
    }

