package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.service.AuctionService;
import io.crowdcode.speedbay.auction.util.CountBidsAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceConfiguration.class)
public class AdviceConfigurationTest {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private CountBidsAdvice countBidsAdvice;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testAdivce() throws Exception {
        auctionService.findAuctions();
    }

    @Test
    public void testCountAdvice() throws Exception {
        Long before = countBidsAdvice.getBidCounts();

        Long auctionId = auctionService.placeAuction(AuctionFixture.buildProductDetail());

        auctionService.bidOnAuction(auctionId, "email", BigDecimal.TEN);

        Long after = countBidsAdvice.getBidCounts();

        assertThat(before+1, is(equalTo(after)));
    }

    @Test
    public void testConfigTest() throws Exception {
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("| " + beanName);
        }

        auctionService.findAuctions();
    }
}