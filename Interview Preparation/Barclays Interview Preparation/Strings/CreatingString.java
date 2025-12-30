public class CreatingString {
    public static void main(String[] args) {

        String str1=new String("Vamshi");

        String str2="Vamshi";

        String str3=new StringBuffer().append("Vamshi").toString();

        String str4=new StringBuilder().append("Vamshi").toString();

        char arr[]={'V','a','m','s','h','i'};
        String str5=new String(arr);


        System.out.println(str1+" "+str2+" "+str3+" "+str4+" "+str5);
    }
}
