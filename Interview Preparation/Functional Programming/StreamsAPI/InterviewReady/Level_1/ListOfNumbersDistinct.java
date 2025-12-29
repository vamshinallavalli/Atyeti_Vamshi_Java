package InterviewReady.Level_1;

import java.util.List;

public class ListOfNumbersDistinct {
    static List<Integer> list=List.of(1,2,3,4,1,2,3,4);

    public static List<Integer> numberOfDistinct(){
        return list.stream().distinct().toList();
    }
}
