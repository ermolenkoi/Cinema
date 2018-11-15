package exceptions;

public class CinemaHallDaoException extends Exception {
    public CinemaHallDaoException() {
    }

    public CinemaHallDaoException(String message) {
        super(message);
    }

    public CinemaHallDaoException(Throwable cause) {
        super(cause);
    }

    public CinemaHallDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
