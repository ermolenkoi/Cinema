package exceptions;

public class ScheduleServiceException extends Exception {
    public ScheduleServiceException() {
    }

    public ScheduleServiceException(String message) {
        super(message);
    }

    public ScheduleServiceException(Throwable cause) {
        super(cause);
    }

    public ScheduleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
