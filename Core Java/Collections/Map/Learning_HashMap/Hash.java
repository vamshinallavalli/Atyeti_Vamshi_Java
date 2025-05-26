package Learning_HashMap;

public class Hash {
    public static void main(String[] args) {
        System.out.println(simpleHash("ABC"));
    }

    public static int simpleHash(String key){
        int sum=0;
        for(char c:key.toCharArray()){
            sum+=(int)c;
        }
        return sum % 10;
    }
}
