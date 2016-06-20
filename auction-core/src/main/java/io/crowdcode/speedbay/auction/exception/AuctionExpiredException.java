package io.crowdcode.speedbay.auction.exception;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionExpiredException extends ApplicationException {
    public AuctionExpiredException() {
    }

    public AuctionExpiredException(String message) {
        super(message);
    }

    public AuctionExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuctionExpiredException(Throwable cause) {
        super(cause);
    }

    public AuctionExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
