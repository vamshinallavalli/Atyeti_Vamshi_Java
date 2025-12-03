package exception;

public class CountryCodeNotAllowedException extends RuntimeException {
    public CountryCodeNotAllowedException(String message) {
        super(message);
    }
}
