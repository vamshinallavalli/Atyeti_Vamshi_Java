package polymorphism;


public class Main {
    public static void main(String[] args) {
        AdvanceCalculator calculator= new AdvanceCalculator();

        System.out.println("Addition: "+calculator.addition(19,11));

        System.out.println("Addition: "+calculator.addition(19.33,11.21));


        System.out.println("Substraction: "+calculator.substraction(33,8));

        System.out.println("Division: "+calculator.division(44,11));

        System.out.println("Multiplication: "+calculator.multiplication(33,22));


        System.out.println("Square root: "+calculator.squareRoot(121));

        System.out.println("Power: "+calculator.power(32));
    }
}
