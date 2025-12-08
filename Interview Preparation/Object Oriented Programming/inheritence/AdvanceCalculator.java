package inheritence;

public class AdvanceCalculator extends Calculator {

    public int squareRoot(int x){
        return (int) Math.sqrt((double) x);
    }

    public int power(int x){
        return (int) Math.pow(x,2);
    }
}
