public class ExceptionOverrideTest {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("In try block");
                throw new RuntimeException("Exception from try");
            } catch (RuntimeException e) {
                System.out.println("In catch block");
                throw new RuntimeException("Exception from catch");
            } finally {
                System.out.println("In finally block");
                throw new RuntimeException("Exception from finally");
            }
        } catch (Exception ex) {
            System.out.println("Caught Exception: " + ex.getMessage());

            for (Throwable suppressed : ex.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}
