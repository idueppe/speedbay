package io.crowdcode.speedbay.auction.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBeanTest {

    @Test
    public void testSpringContext() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        AuctionService auctionService = context.getBean("auctionService", AuctionService.class);
        assertNotNull(auctionService);
    }

}