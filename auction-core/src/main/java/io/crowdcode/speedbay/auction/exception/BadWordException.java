package io.crowdcode.speedbay.auction.exception;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class BadWordException extends SystemException {

    public BadWordException() {
    }

    public BadWordException(String message) {
        super(message);
    }

    public BadWordException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadWordException(Throwable cause) {
        super(cause);
    }

    public BadWordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
