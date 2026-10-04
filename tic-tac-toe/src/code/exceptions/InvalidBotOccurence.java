package code.exceptions;

public class InvalidBotOccurence  extends RuntimeException{
    public InvalidBotOccurence() {
    }

    public InvalidBotOccurence(String message) {
        super(message);
    }

    public InvalidBotOccurence(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBotOccurence(Throwable cause) {
        super(cause);
    }

    public InvalidBotOccurence(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
