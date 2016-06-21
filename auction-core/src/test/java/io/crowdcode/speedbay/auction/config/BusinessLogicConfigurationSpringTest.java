package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusinessLogicConfiguration.class)
public class BusinessLogicConfigurationSpringTest {

    @Autowired
    private AuctionService auctionService;


    @Test
    @Repeat(10)
    @DirtiesContext
    public void testApplicationContextWithIntegration() throws Exception {
        Long auctionId = auctionService.placeAuction(AuctionFixture.buildProductDetail());

        auctionService.bidOnAuction(auctionId, "test@junit.org", BigDecimal.valueOf(11));
        Auction auction = auctionService.findAuction(auctionId);
        assertThat(auction.getHighestBid().getAmount().doubleValue(), is(11.0));

        assertThat(auctionService.findAuctions(), hasSize(1));
    }

}