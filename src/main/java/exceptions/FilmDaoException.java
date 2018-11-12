package exceptions;

public class FilmDaoException extends Exception {

    public FilmDaoException() {
    }

    public FilmDaoException(String message) {
        super(message);
    }

    public FilmDaoException(Throwable cause) {
        super(cause);
    }

    public FilmDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
