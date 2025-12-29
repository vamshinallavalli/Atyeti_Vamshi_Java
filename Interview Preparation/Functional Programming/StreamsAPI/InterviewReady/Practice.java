package InterviewReady;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        List<Integer> list=Arrays.stream(arr).boxed().filter(s->s%2==0).toList();
//
//        System.out.println(list);

//        String name="Vamshi";
//
//        Map<Character,Long> freq=name.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(s->s,Collectors.counting()));
//
//        System.out.println(freq);


        //int sum=Arrays.stream(arr).boxed().mapToInt(Integer::intValue).sum();

        //int sum=Arrays.stream(arr).reduce(0,Integer::sum);

        //long count=Arrays.stream(arr).boxed().filter(s->s%2==0).count();

        //int max=Arrays.stream(arr).max().orElseThrow();


//        Set<Integer> seen=new HashSet<>();
//
//        Set<Integer> duplicates=Arrays.stream(arr).boxed().filter(s->!seen.add(s)).collect(Collectors.toSet());
//        System.out.println(duplicates);


        int[] arr = {3, 2, 1, 4, 7, 9, 8, 5};

        List<Integer> sortedOdds = Arrays.stream(arr)
                .boxed()
                .filter(n -> n % 2 != 0)
                .sorted()
                .toList();

        int oddIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = sortedOdds.get(oddIndex++);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}