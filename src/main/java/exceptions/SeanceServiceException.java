package exceptions;

public class SeanceServiceException extends Exception {
    public SeanceServiceException() {
    }

    public SeanceServiceException(String message) {
        super(message);
    }

    public SeanceServiceException(Throwable cause) {
        super(cause);
    }

    public SeanceServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
