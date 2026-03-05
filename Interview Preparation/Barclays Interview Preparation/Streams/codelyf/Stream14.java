import java.util.Arrays;

public class Stream14 {
    public static void main(String[] args) {

        int i = 15623;

        int sum = Arrays.stream(String.valueOf(i).split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(sum);
    }
}