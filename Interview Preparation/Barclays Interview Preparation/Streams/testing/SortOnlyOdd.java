package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortOnlyOdd {
    public static void main(String[] args) {
        int arr[]={4,2,4,5,6,7,1,3};

        List<Integer> list=Arrays.stream(arr).boxed().filter(s->s%2!=0).sorted().toList();

int count=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                arr[i]=list.get(count++);
            }
        }



        for(int x:arr){
            System.out.print(x+" ");
        }

    }
}
