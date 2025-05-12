import java.util.Random;
import java.util.function.Supplier;

public class GenerateRandomNumbers {
    public static void generatingNumbers(){

        Random random=new Random();
        Supplier<Integer> randomNumbers=()->random.nextInt(100) + 1;;

        System.out.print("5 Series of Random Numbers: ");
        for(int i=0;i<5;i++){
            System.out.print(randomNumbers.get()+" ");
        }
    }
}
