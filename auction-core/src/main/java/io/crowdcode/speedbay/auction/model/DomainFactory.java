package io.crowdcode.speedbay.auction.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class DomainFactory implements BeanFactoryAware {

    private static final Logger log = LoggerFactory.getLogger(DomainFactory.class);

    private BeanFactory beanFactory;

    public Product createProduct() {
        ProductDetail product = beanFactory.getBean("product", ProductDetail.class);
        log.info("Create Product {}.", product);
        return product;
    }

    public Auction createAuction() {
        return beanFactory.getBean("auction", Auction.class);
    }

    public Bid createBid() {
        return beanFactory.getBean("bid", Bid.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
