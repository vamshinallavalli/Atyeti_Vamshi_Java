public class WrapperVsObject {

        void m(Object o) {
            System.out.println("Object");
        }

        void m(String i) {
            System.out.println("Integer");
        }

        public static void main(String[] args) {
            WrapperVsObject t = new WrapperVsObject();
            t.m(10);
            t.m("hello");
        }
    }


