public class PrimitiveWideningVsAtoBoxing {
    public static void main(String[] args) {
        PrimitiveWideningVsAtoBoxing obj=new PrimitiveWideningVsAtoBoxing();

        System.out.println(obj.check(4));
    }

    public String check(long l){
        return "long";
    }

    public String check(Integer l){
        return "Integer";
    }
}
