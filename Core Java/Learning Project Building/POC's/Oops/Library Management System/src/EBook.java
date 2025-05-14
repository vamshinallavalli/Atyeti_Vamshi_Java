public class EBook extends Book{
    private double fileSize;
    private String format;

    public EBook(String author, boolean available, String ISBN, String title) {
        super(author, ISBN, title,available);
    }

    public void borrow(){

    }
}
