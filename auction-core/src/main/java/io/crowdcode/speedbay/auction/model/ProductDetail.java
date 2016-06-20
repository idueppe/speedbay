package io.crowdcode.speedbay.auction.model;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class ProductDetail extends Product<ProductDetail> {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDetail withDescription(final String description) {
        this.description = description;
        return this;
    }

}
