import java.util.List;

public class MaximumIndex {
    public int maxIndexDiff(int[] arr) {
        int max=arr[0];

        for(int i=0;i<arr.length;i++){
            if(i>max)
                max=i;
        }

        return max;
    }
}
