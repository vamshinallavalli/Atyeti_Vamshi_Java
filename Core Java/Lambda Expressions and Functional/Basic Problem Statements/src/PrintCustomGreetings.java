import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintCustomGreetings {
    public static void customGreetings(){

        Consumer<String> consumer= s->System.out.println("Hello "+s+"!");

        List<String> names= Arrays.asList("Alice", "Bob", "Charlie");

        names.forEach(consumer);

    }
}
