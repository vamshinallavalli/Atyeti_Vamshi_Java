package AdvanceCollectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

// Summarizes numeric values (count, sum, min, average, max).
public class Collectors_summarizingInt_Double_Long {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3);
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(stats);
// Output: IntSummaryStatistics{count=5, sum=15, min=1, average=3.0, max=5}

    }
}
