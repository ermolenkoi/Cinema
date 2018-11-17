package exceptions;

public class PositionBookingDaoException extends Exception {

    public PositionBookingDaoException() {
    }

    public PositionBookingDaoException(String message) {
        super(message);
    }

    public PositionBookingDaoException(Throwable cause) {
        super(cause);
    }

    public PositionBookingDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
