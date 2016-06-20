package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBeanTest {

    private static ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:exercise-6.xml");
    }

    @Test
    public void testSpringContext() throws Exception {
        AuctionService auctionService = applicationContext.getBean("auctionService", AuctionService.class);
        assertNotNull(auctionService);
    }

    @Test
    public void testApplicationContextWithIntegration() throws Exception {
        AuctionRepository repository = applicationContext.getBean("auctionRepository", AuctionRepository.class);
        assertNotNull(repository);

        AuctionService service = applicationContext.getBean("auctionService", AuctionService.class);
        assertNotNull(service);

        Long auctionId = service.placeAuction(AuctionFixture.buildProductDetail());
        assertThat(auctionId, is(notNullValue()));

        service.bidOnAuction(auctionId, "test@junit.org", BigDecimal.valueOf(11));
        Auction auction = service.findAuction(auctionId);
        assertThat(auction.getHighestBid().getAmount().doubleValue(), is(11.0));
    }
}