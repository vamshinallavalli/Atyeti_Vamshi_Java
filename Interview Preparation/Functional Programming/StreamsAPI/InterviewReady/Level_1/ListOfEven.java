package InterviewReady.Level_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfEven {

    static int arr[]={1,2,3,4,5,6,7,8,9,10};
    public static List<Integer> listOfEven(){
        List<Integer> list= Arrays.stream(arr).boxed().filter(s->s%2==0).toList();

        return list;
    }
}
