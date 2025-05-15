public class CustomFunctionalInterface {
    public static void customInterface(){

        Calculator addition=(a,b)->a+b;

        Calculator subtraction=(a,b)->a-b;

        Calculator multiplication=(a,b)->a*b;

        Calculator division=(a,b)->{
            if(b==0)
                System.out.println("denominator should not be Zero");

            return a;
        };
        System.out.println("/n");
        System.out.println("Addition is: "+addition.operate(9,1));
        System.out.println("subtraction is: "+subtraction.operate(9,1));
        System.out.println("multiplication is: "+multiplication.operate(9,8));
        System.out.println("division is: "+division.operate(9,1));

    }
}

@FunctionalInterface
interface Calculator{
    int operate(int a, int b);
}
