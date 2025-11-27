package spring.i_curve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UnimailProperties.class)
public class UnimailAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(UnimailAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean(UnimailService.class)
    public UnimailService unimailService(UnimailProperties properties) {
        if (properties.getKey() == null || properties.getKey().isEmpty()) {
            log.info("the unimail key is null");
        }
        UnimailService unimailService = new UnimailService(properties.getKey());
        if (properties.getHost() != null && !properties.getHost().isEmpty())
            unimailService.setHost(properties.getHost());
        if (properties.getLang() != null && !properties.getLang().isEmpty())
            unimailService.setLang(properties.getLang());
        return unimailService;
    }
}
