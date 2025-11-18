package TwoPoninters;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] arr,int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int compliment=target-arr[i];

            if(map.containsKey(compliment)){
                return new int[] {map.get(compliment),i};
            }
            map.put(arr[i],i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

}
