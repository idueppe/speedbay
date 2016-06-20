package io.crowdcode.speedbay.auction.model;

import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Bid extends AbstractEntity<Bid, Long> {

    private String email;
    private BigDecimal amount;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bid withEmail(final String email) {
        this.email = email;
        return this;
    }

    public Bid withAmount(final BigDecimal amount) {
        this.amount = amount;
        return this;
    }

}
