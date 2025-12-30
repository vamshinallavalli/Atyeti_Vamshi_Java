package Easy;

import java.util.Arrays;

public class CheckAllArePositiveUsingAllMatch {
    public static void main(String[] args) {

        int arr1[]={1,2,3,4,5,6,7};
        int arr2[]={1,2,-3,4,5,6,7};


        System.out.println(Arrays.stream(arr1).allMatch(s->s>0));
        System.out.println(Arrays.stream(arr2).allMatch(s->s>0));
    }
}
