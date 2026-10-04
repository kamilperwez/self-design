package code.exceptions;

public class DrawGameException extends RuntimeException{
    public DrawGameException() {
    }

    public DrawGameException(String message) {
        super(message);
    }

    public DrawGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DrawGameException(Throwable cause) {
        super(cause);
    }

    public DrawGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
