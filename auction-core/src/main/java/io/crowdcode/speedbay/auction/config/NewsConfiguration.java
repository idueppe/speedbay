package io.crowdcode.speedbay.auction.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.crowdcode.speedbay.common.AnsiColor.blue;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
public class NewsConfiguration {

    private static final Logger log = LoggerFactory.getLogger(NewsConfiguration.class);

    @Autowired
    private NewsProvider newsProvider;

    @Bean
    public NewsPaper newsPaper(NewsProvider newsProvider) {
        log.info(blue("creating news paper"));
        return new NewsPaper(newsProvider);
    }

    @Bean
    public NewsPaper newsPaperSamstag() {
        log.info(blue("creating news paper samstag"));
        return new NewsPaper(newsProvider());
    }

    @Bean
    public NewsPaper newsPaperFreitag() {
        log.info(blue("creating news paper samstag"));
        return new NewsPaper(newsProvider());
    }


    @Bean
    public NewsPaper newsPaperSonntag() {
        log.info(blue("creating news paper sonntag"));
        return new NewsPaper(newsProvider);
    }


    @Bean
    public NewsProvider newsProvider() {
        log.info(blue("creating news provider"));
        return new NewsProvider();
    }


}
