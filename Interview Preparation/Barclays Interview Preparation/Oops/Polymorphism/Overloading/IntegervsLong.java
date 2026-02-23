public class IntegervsLong {
    public static void main(String[] args) {
        IntegervsLong obj=new IntegervsLong();

        System.out.println(obj.check(10));
    }

    public String check(Integer x){
        return "Integer Wrapper Class";
    }

    public String check(Long x){
        return "Long Wrapper Class";
    }
}
