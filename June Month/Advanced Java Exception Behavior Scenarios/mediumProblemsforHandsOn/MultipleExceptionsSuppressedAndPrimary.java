package mediumProblemsforHandsOn;

public class MultipleExceptionsSuppressedAndPrimary {
    public static void main(String[] args) {
        try(closer close=new closer()){
            throw new Exception("Exception from try block");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed);
            }
        }
    }
}

class closer implements AutoCloseable{

    @Override
    public void close(){
        throw new RuntimeException("Exception from close() ");
    }
}
