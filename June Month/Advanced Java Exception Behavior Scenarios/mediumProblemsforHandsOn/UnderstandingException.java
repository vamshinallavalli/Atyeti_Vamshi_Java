package mediumProblemsforHandsOn;

public class UnderstandingException {
    public static void main(String[] args) {
        int[] numerators={10,200,30,40};
        int[] denominators={1,2,0,4};

        for(int i=0;i<numerators.length;i++){
            System.out.println(divide(numerators[i],denominators[i]));
        }
        System.out.println("Good job :)");
    }

    private static int divide(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (Exception e) {
           // throw new RuntimeException("Unable to divide by Zero");
            System.out.print("Unable to divide by "+e.toString());
            return 0;
        }
    }
}
