package Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveAllNull {
    public static void main(String[] args) {

        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,null));

        System.out.println(arr.stream().filter(s->s!=null).collect(Collectors.toList()));
    }
}
