package polymorphism;


public class AdvanceCalculator extends Calculator {

    public int squareRoot(int x){
        return (int) Math.sqrt((double) x);
    }

    public int power(int x){
        return (int) Math.pow(x,2);
    }

    public int addition(int x,int y){
        return x+y+1;
    }
}
