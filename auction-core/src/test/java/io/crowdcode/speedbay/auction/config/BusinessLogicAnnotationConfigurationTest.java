package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.ProductDetail;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.auction.service.AuctionService;
import io.crowdcode.speedbay.common.inmemory.InMemoryStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.crowdcode.speedbay.common.AnsiColor.green;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusinessLogicAnnotationConfiguration.class)
public class BusinessLogicAnnotationConfigurationTest {

    public static final Logger log = LoggerFactory.getLogger(BusinessLogicAnnotationConfigurationTest.class);

    @Autowired
    private InMemoryStore inMemoryStore;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testConfigTest() throws Exception {
        assertNotNull(inMemoryStore);
        assertNotNull(auctionService);
        assertNotNull(auctionRepository);
    }

    @Test
    public void testIfBeansAreCorrectlyWiredTogether() throws Exception {
        ProductDetail productDetail = AuctionFixture.buildProductDetail();
        Long auctionId = auctionService.placeAuction(productDetail);
        Auction auction = auctionService.findAuction(auctionId);
        assertNotNull(auction);
    }

    @Test
    public void testLogBeanNames() throws Exception {

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            log.info(green(beanName));
        }
    }
}