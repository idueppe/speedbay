package io.crowdcode.speedbay.auction.model;


import io.crowdcode.speedbay.common.Identifiable;

import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Product<T extends Product> extends AbstractEntity<T, Long> implements Identifiable<Long> {

    private String title;
    private BigDecimal minAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    @SuppressWarnings("unchecked")
    public T withTitle(final String title) {
        this.title = title;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withMinAmount(final BigDecimal minAmount) {
        this.minAmount = minAmount;
        return (T) this;
    }


}
