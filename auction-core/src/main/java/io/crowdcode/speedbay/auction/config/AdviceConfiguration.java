package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.util.CountBidsAdvice;
import io.crowdcode.speedbay.auction.util.LoggingAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
@EnableAspectJAutoProxy
public class AdviceConfiguration {


    @Bean
    public static LoggingAdvice loggingAdvice() {
        return new LoggingAdvice();
    }

    @Bean
    public static CountBidsAdvice countBidsAdvice() {
        return new CountBidsAdvice();
    }
}
