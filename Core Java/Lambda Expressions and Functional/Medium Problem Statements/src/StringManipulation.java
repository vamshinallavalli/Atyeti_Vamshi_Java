class StringManipulation {
    public void manipulation() {
        String str="Hello";

        String upper=str->str.to
    }
}

@FunctionalInterface
interface StringOperation {
    String apply(String str);
}





































//@FunctionalInterface
//interface StringOperation {
//    String apply(String str);
//}
//
//public class StringManipulation {
//    public static void main(String[] args) {
//        String sample = "Hello, World!";
//
//        StringOperation toUpperCase = str -> str.toUpperCase();
//
//        StringOperation reverse = str -> new StringBuilder(str).reverse().toString();
//
//        StringOperation removeVowels = str -> str.replaceAll("(?i)[aeiou]", "");
//
//        System.out.println("Original:      " + sample);
//        System.out.println("Uppercase:     " + toUpperCase.apply(sample));
//        System.out.println("Reversed:      " + reverse.apply(sample));
//        System.out.println("No Vowels:     " + removeVowels.apply(sample));
//    }
//}
