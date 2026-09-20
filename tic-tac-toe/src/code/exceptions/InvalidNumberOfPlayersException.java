package code.exceptions;

public class InvalidNumberOfPlayersException extends RuntimeException{
    public InvalidNumberOfPlayersException() {
    }

    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }

    public InvalidNumberOfPlayersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfPlayersException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberOfPlayersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
