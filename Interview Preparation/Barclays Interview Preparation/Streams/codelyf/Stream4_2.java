// How do you sort the given list of decimals in reverse order?

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream4_2 {
    public static void main(String[] args) {
        List<Double> decimalList= Arrays.asList(12.45,23.58,17.13,42.89,33.78,71.85,56.98,21.12);

        List<Double> sortedDecimals=decimalList.stream().sorted(Comparator.naturalOrder()).toList();

        System.out.println(sortedDecimals);
    }
}
