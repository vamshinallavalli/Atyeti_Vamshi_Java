package InterviewReady.Level_1;

import java.util.Comparator;
import java.util.List;

public class SortElementsInDescending {
    static List<Integer> list=List.of(3,1,2,5,7,4,8,9);

    public static List<Integer> sortingInDescendingOrder(){
        return list.stream().sorted().toList().reversed();
    }
}
