package code.exceptions;

public class InvalidBoardDimensionException extends RuntimeException{
    public InvalidBoardDimensionException() {
    }

    public InvalidBoardDimensionException(String message) {
        super(message);
    }

    public InvalidBoardDimensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBoardDimensionException(Throwable cause) {
        super(cause);
    }

    public InvalidBoardDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
