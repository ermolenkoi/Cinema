package exceptions;

public class PositionServiceExceptions extends Exception {

    public PositionServiceExceptions() {
    }

    public PositionServiceExceptions(String message) {
        super(message);
    }

    public PositionServiceExceptions(Throwable cause) {
        super(cause);
    }

    public PositionServiceExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
