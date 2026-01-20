class Test {
    //@SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t = null;

        System.gc(); // Request GC
    }
}
