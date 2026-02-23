//class Test {
//    void m(Long l) {}
//    void m(Float f) {}
//
//    public static void main(String[] args) {
//      //  new Test().m(10); // ❌ ambiguous
//    }
//}

class Test {
    void m(byte b) {
        System.out.println("byte");
    }

    void m(int i) {
        System.out.println("int");
    }

    public static void main(String[] args) {
        byte b = 10;
        Test t = new Test();
        t.m(b);
    }
}
