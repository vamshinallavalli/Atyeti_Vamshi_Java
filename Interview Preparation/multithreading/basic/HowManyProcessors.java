package basic;

public class HowManyProcessors {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Your machine has " + processors + " logical processors/cores");
    }
}