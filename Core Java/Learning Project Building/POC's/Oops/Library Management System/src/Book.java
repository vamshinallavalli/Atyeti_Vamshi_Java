public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String author, String ISBN, String title, boolean available) {
        this.author = author;
        this.title = title;
        this.isbn=ISBN;
        this.available=available;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook(){
        if(available){
            available=false;
            System.out.println("Book Borrowed: "+author);
        }else System.out.println("Book Not Available");
    }

    public void returnBook(){
        available=true;

        System.out.println("Book Returned: "+title);
    }

    public void displayInfo(){

        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("ISBN: "+isbn);
        System.out.println("Available: "+available);
    }
}
