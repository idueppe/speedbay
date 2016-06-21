package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.auction.service.AuctionService;
import io.crowdcode.speedbay.common.inmemory.InMemoryStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusinessLogicLoggingBeanPostProcessorConfiguration.class)
public class BusinessLogicLoggingBeanPostProcessorConfigurationTest {

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

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("| " + beanName);
        }
    }

}