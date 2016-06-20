package io.crowdcode.speedbay.auction.service;


import io.crowdcode.speedbay.auction.exception.AuctionExpiredException;
import io.crowdcode.speedbay.auction.exception.AuctionNotFoundException;
import io.crowdcode.speedbay.auction.exception.BitToLowException;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import io.crowdcode.speedbay.auction.model.ProductDetail;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static io.crowdcode.speedbay.common.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBean implements AuctionService {

    private static final Logger log = LoggerFactory.getLogger(AuctionServiceBean.class);

    private AuctionRepository auctionRepository;

    public AuctionServiceBean() {
        log.info(green("Here I am!"));
    }

    @Override
    public Long placeAuction(ProductDetail productDetail) {
        log.info("Creating a new auction as \"{}\" ", productDetail.getTitle());
        Auction auction = new Auction()
                .withOwner("anonymous")
                .withBeginDate(LocalDateTime.now().plus(1, ChronoUnit.MINUTES))
                .withExpireDate(LocalDateTime.now().plus(5, ChronoUnit.MINUTES))
                .withProduct(new ProductDetail()
                        .withTitle(productDetail.getTitle())
                        .withMinAmount(productDetail.getMinAmount())
                        .withDescription(productDetail.getDescription()));
        auctionRepository.save(auction);
        return auction.getId();
    }

    @Override
    public List<Auction> findRunning() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findAuction(Long auctionId) throws AuctionNotFoundException {
        return auctionRepository
                .find(auctionId)
                .orElseThrow(() -> new AuctionNotFoundException(auctionId));
    }

    @Override
    public Bid bidOnAuction(Long auctionId, String email, BigDecimal amount) throws AuctionNotFoundException, AuctionExpiredException, BitToLowException {
        Auction auction = findAuction(auctionId);

        Bid highestBid = auction.getHighestBid();
        if (highestBid != null && highestBid.getAmount().compareTo(amount) > -1) {
            throw new BitToLowException(highestBid);
        }
        Bid bid = new Bid().withAmount(amount).withEmail(email);
        auction.getBids().add(bid);
        auctionRepository.save(auction);
        return bid;
    }

    public void setAuctionRepository(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }
}
