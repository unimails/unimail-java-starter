package top.allcloud;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

@AutoConfiguration
@EnableConfigurationProperties(UnimailProperties.class)
public class UnimailAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(UnimailService.class)
    @ConditionalOnProperty(prefix = "unimail", name = "enabled", havingValue = "true", matchIfMissing = true)
    public UnimailService unimailService(UnimailProperties properties) {
        if (!StringUtils.hasText(properties.getKey())) {
            throw new IllegalStateException("Property 'unimail.key' must not be blank when unimail is enabled");
        }

        UnimailService unimailService = new UnimailService(properties.getKey());
        if (StringUtils.hasText(properties.getHost()))
            unimailService.setHost(properties.getHost());
        if (StringUtils.hasText(properties.getLanguage()))
            unimailService.setLanguage(properties.getLanguage());

//        log.debug("Configured UnimailService with custom host/language settings");
        return unimailService;
    }
}
