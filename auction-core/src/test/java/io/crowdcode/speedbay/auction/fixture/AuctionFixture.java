package io.crowdcode.speedbay.auction.fixture;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import io.crowdcode.speedbay.auction.model.ProductDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author Ingo Dueppe (Crowdcode)
 */
public class AuctionFixture {

    public static Auction createTestAuction(String title, int amount) {
        return buildAuction()
                .withProduct(
                        new ProductDetail().withDescription("description")
                                .withMinAmount(BigDecimal.ONE)
                                .withTitle(title))
                .withBids(Arrays.asList(
                        new Bid()
                                .withAmount(BigDecimal.valueOf(amount))
                                .withEmail("kontakt@crowdcode.io")));
    }

    public static Auction buildDefaultAuction() {
        return buildAuction()
                .withProduct(buildProductDetail())
                .withBids(Arrays.asList(
                        buildLowBid(),
                        buildHighBid())
                );
    }

    public static Auction buildAuction() {
        return new Auction()
                .withBeginDate(LocalDateTime.now())
                .withExpireDate(LocalDateTime.now().plus(2, ChronoUnit.MINUTES))
                .withOwner("unittest");
    }

    public static Bid buildHighBid() {
        return new Bid()
                .withAmount(BigDecimal.TEN)
                .withEmail("test@unit.org");
    }

    public static Bid buildLowBid() {
        return new Bid()
                .withAmount(BigDecimal.ONE)
                .withEmail("unit@test.org");
    }

    public static ProductDetail buildProductDetail() {
        return new ProductDetail()
                .withTitle("MacBook Pro")
                .withMinAmount(BigDecimal.ONE)
                .withDescription("MacBook Pro 15\" Retina");
    }
}