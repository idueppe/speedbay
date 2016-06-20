package io.crowdcode.speedbay.auction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.crowdcode.speedbay.common.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBean implements AuctionService {

    private static final Logger log = LoggerFactory.getLogger(AuctionServiceBean.class);

    public AuctionServiceBean() {
        log.info(green("Here I am!"));
    }


}
