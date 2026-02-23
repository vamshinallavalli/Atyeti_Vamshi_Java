public class ExactPreferred {
    public static void main(String[] args) {
        ExactPreferred obj=new ExactPreferred();

        System.out.println(obj.sum(1,5));
    }

    public int sum(int a,int b){
       return a+b;
    }

    public Integer sum(Integer a,Integer b){
        return a+b;
    }
}


