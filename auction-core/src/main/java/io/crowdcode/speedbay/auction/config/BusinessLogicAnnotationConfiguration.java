package io.crowdcode.speedbay.auction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(
        basePackages = {"io.crowdcode.speedbay.auction", "io.crowdcode.speedbay.common.inmemory"},
        excludeFilters =
                {
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "io\\.crowdcode\\.speedbay\\.auction\\.config.*")
                }
)
public class BusinessLogicAnnotationConfiguration {


}
