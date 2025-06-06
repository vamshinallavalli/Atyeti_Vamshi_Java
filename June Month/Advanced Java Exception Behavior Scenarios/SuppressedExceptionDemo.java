class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from close()");
    }
}

public class SuppressedExceptionDemo {
    public static void main(String[] args) {
        try (MyResource res = new MyResource()) {
            throw new Exception("Exception from try block");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed);
            }
        }
    }
}
