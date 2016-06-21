package io.crowdcode.speedbay.auction.util;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.crowdcode.speedbay.common.AnsiColor.green;


/**
 * @author Ingo Düppe (Crowdcode)
 */
@Aspect
public class CountBidsAdvice {

    private static final Logger log = LoggerFactory.getLogger(CountBidsAdvice.class);

    private long count;

    @AfterReturning("execution(* io.crowdcode.speedbay.auction.service.AuctionService.bidOnAuction(..))")
    public void counting() throws Throwable {
        count++;
        log.info(green("Bid on auction was called. Added +1 to count. Count is now {} "), count );
    }

    public Long getBidCounts() {
        return count;
    }

}
