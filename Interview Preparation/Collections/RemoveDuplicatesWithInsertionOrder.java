import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicatesWithInsertionOrder {
    public static void main(String[] args) {
        int arr[]={9,8,7,6,5,7,3,2,1};

        LinkedHashSet<Integer> list=new LinkedHashSet<>();

        for(int i:arr){
            list.add(i);
        }

        System.out.println(list);


    }
}
