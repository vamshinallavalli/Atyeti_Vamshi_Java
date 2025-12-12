import java.util.*;
import java.util.stream.Collectors;

public class SortOnlyOddInArray {
    public static void main(String[] args) {
        int arr[]={9,8,7,6,5,4,3,2,1};

        List<Integer> odd=new ArrayList<>();

        for(int x:arr){
            if(x%2!=0)
                odd.add(x);
        }

        int oddCount=0;

        Collections.sort(odd);

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                arr[i]=odd.get(oddCount++);
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
