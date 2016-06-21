package io.crowdcode.speedbay.auction.config;


import io.crowdcode.speedbay.auction.util.LoggingBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
public class BusinessLogicLoggingBeanPostProcessorConfiguration {

    @Bean()
    public static LoggingBeanPostProcessor postProcessor() {
        return new LoggingBeanPostProcessor();
    }

}
