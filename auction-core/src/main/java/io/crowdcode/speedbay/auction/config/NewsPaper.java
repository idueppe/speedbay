package io.crowdcode.speedbay.auction.config;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class NewsPaper {

    private NewsProvider newsProvider;

    public NewsPaper(NewsProvider newsProvider) {
        this.newsProvider = newsProvider;
    }
}
