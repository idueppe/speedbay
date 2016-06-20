package io.crowdcode.speedbay.auction.exception;

import io.crowdcode.speedbay.auction.model.Bid;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class BitToLowException extends ApplicationException {
    public BitToLowException(Bid highestBid) {
        super("The bid is to low. Current highestBid is " + highestBid.toString());
    }
}
