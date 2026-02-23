public class Intvslong {
    public static void main(String[] args) {
        Intvslong obj=new Intvslong();

        System.out.println(obj.check(2147483647));
    }

    public String check(int x){
      return "int primitive";
    }

    public String check(long x){
        return "long primitive";
    }
}
