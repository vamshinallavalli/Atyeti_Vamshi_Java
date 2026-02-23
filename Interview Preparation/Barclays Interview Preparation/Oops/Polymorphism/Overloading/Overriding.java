class Overloading{
    public static void main(String[] args) {
        Overloading obj=new Overloading();

        System.out.println(obj.sum(1,2));

    }

    public long sum(long a,long b){
       return a+b;
    }

    public int sum(int a,int b){
        return a+b;
    }
}