public class OverloadStatic {
    public static void main(String[] args) {
        System.out.println(check(Integer.valueOf(8)));
    }

    public static String check(int n){
        return "int primitive";
    }

    public static String check(Integer n){
        return "Integer Wrapper";
    }
}
