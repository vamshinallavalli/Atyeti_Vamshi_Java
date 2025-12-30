package Easy;

import java.util.Arrays;
import java.util.List;

public class FindFirstElementUsingFindFirst {
    public static void main(String[] args) {
        int arr[]={1,3,1,3,4,6,6,7,8,7};

        System.out.println(Arrays.stream(arr).findFirst().getAsInt());

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        list.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
