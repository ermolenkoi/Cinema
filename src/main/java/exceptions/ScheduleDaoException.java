package exceptions;

public class ScheduleDaoException extends Exception {
    public ScheduleDaoException() {
    }

    public ScheduleDaoException(String message) {
        super(message);
    }

    public ScheduleDaoException(Throwable cause) {
        super(cause);
    }

    public ScheduleDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
