package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.auction.config.DomainFactoryConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainFactoryConfiguration.class)
public class DomainFactoryTest {

    @Autowired
    private DomainFactory domainFactory;

    @Test
    public void testPrototypeScopeOfProduct() throws Exception {
        Product one = domainFactory.createProduct();
        Product two = domainFactory.createProduct();

        assertFalse(one == two);
        assertEquals(one.getMinAmount(), BigDecimal.TEN);
    }

    @Test
    public void testPrototypeScopeOfAuction() throws Exception {
        assertFalse(domainFactory.createAuction() == domainFactory.createAuction());
    }

    @Test
    public void testPrototypeScopeOfBid() throws Exception {
        assertFalse(domainFactory.createBid() == domainFactory.createBid());
    }
}