import java.util.HashMap;
import java.util.Map;

public class SortMapBasedOnValues {
    public static void main(String[] args) {
        String str="aabbccdeff";

        Map<Character,Integer> map=new HashMap<>();

        for(char c:str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
