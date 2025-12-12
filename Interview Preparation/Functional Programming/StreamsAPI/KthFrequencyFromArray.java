import java.util.*;
import java.util.Map;

public class KthFrequencyFromArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,3,2,5,5,7,6,6};

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int x:arr){
            map.put(x,map.getOrDefault(x, 0)+1);
        }

        int k=2;

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

        // Step 3: Find K-th frequency
        long kthFreq = list.get(k - 1).getValue();

        System.out.println("K-th frequency value = " + kthFreq);

        System.out.print("Elements with K-th frequency: ");
        for (Map.Entry<Integer,Integer> e : list) {
            if (e.getValue() == kthFreq)
                System.out.print(e.getKey() + " ");
        }
    }
}
