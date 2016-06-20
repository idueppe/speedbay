package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionTest {

    @Test
    public void testGetHighestBid() throws Exception {
        assertThat(AuctionFixture
                .buildDefaultAuction()
                .getHighestBid()
                .getAmount()
                .doubleValue(), is(10.0));
    }

}