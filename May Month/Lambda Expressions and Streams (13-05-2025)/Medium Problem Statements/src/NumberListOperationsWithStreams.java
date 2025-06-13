import java.util.Arrays;
import java.util.List;

public class NumberListOperationsWithStreams {
    public static void operationsWithStreams(){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

       // Integer sum=list.stream().filter(s->s%2==0).map(s->s*s).reduce(0, Integer::sum);
        int sum=list.stream().filter(s->s%2==0).mapToInt(s->s*s).sum();


        System.out.println(sum);
    }
}
