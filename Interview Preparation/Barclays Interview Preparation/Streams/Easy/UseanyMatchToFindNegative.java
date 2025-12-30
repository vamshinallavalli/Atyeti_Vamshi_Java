package Easy;

import java.util.Arrays;

public class UseanyMatchToFindNegative {
    public static void main(String[] args) {
        int arr[]={1,2,4,7,-1,-2,8,7};

        System.out.println(Arrays.stream(arr).anyMatch(s -> s < -1));
    }
}
