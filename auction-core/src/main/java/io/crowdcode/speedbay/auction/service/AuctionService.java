package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.exception.AuctionExpiredException;
import io.crowdcode.speedbay.auction.exception.AuctionNotFoundException;
import io.crowdcode.speedbay.auction.exception.BitToLowException;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import io.crowdcode.speedbay.auction.model.ProductDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionService {

    /**
     * Place an new auction to the registry.
     *
     * @param productDetail
     * @return auctionId
     */
    Long placeAuction(ProductDetail productDetail);

    /**
     * Find all auctions
     *
     * @return List<Auction>
     */
    List<Auction> findAuctions();

    /**
     * Find an Auction-Entity by its id;
     *
     * @param auctionId
     * @return Auction entity object
     * @throws AuctionNotFoundException, if no Auction with the auctionId is found.
     */
    Auction findAuction(Long auctionId) throws AuctionNotFoundException;

    /**
     * Place bid on a given Auction
     *
     * @param auctionId
     * @param email
     * @param amount
     * @return Bid Entity
     * @throws AuctionNotFoundException, thrown if no auction is found by the provided paramter
     * @throws BitToLowException,        thrown if the amount is equal or lower as the highest bid
     */
    Bid bidOnAuction(Long auctionId, String email, BigDecimal amount) throws AuctionNotFoundException, AuctionExpiredException, BitToLowException;
}
