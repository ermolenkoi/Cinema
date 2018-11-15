package exceptions;

public class SeanceDaoException extends Exception {
    public SeanceDaoException() {
    }

    public SeanceDaoException(String message) {
        super(message);
    }

    public SeanceDaoException(Throwable cause) {
        super(cause);
    }

    public SeanceDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
