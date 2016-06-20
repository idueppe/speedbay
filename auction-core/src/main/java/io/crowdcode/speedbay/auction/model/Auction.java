package io.crowdcode.speedbay.auction.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Auction extends AbstractEntity<Auction, Long> {

    private String owner;

    private LocalDateTime beginDate;

    private LocalDateTime expireDate;

    private Product product;

    private List<Bid> bids = new ArrayList<>();

    public Bid getHighestBid() {
        return bids
                .stream()
                .max((b1, b2) -> b1.getAmount().compareTo(b2.getAmount())).orElse(null);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Auction withOwner(final String owner) {
        this.owner = owner;
        return this;
    }

    public Auction withBeginDate(final LocalDateTime beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public Auction withExpireDate(final LocalDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public Auction withProduct(final Product product) {
        this.product = product;
        return this;
    }

    public Auction withBids(final List<Bid> bids) {
        this.bids = bids;
        return this;
    }


}
