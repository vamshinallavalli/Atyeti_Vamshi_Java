package InterviewReady.Level_1;

import java.util.List;

public class SortElementsInAscending {
    static List<Integer> list=List.of(3,1,2,5,7,4,8,9);

    public static List<Integer> sortingInAscendingOrder(){
        return list.stream().sorted().toList();
    }
}
