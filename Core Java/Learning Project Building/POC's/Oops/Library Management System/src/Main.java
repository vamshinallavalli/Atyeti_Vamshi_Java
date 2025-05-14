public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert C. Martin", "1234567890",true);

        Book book2 = new Book("Kerthy Sierra", "John Wick","OCP Java",true);
        book1.displayInfo();
        System.out.println("--------------------------------------");
        book1.borrowBook();
        book1.displayInfo();
        System.out.println("--------------------------------");
        book1.returnBook();
        book1.displayInfo();




        System.out.println("--------------------------------");
        book2.displayInfo();
        System.out.println("--------------------------------------");
        book2.borrowBook();
        book2.displayInfo();

    }
}