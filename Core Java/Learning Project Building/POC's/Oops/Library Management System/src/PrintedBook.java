public class PrintedBook extends Book{
    private int pages;
    private String shelfLocation;

    public PrintedBook(String author, boolean available, String isbn, String title) {
        super(author, isbn, title,available);
    }

    public void borrow(){

    }
}
