package spring.i_curve;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UnimailProperties.class)
public class UnimailAutoConfiguration {
    @Bean
    public UnimailService unimailService(UnimailProperties properties) {
        if (properties.getKey() == null || properties.getKey().isEmpty()) return null;
        UnimailService unimailService = new UnimailService(properties.getKey());
        if (properties.getHost() != null && !properties.getHost().isEmpty())
            unimailService.setHost(properties.getHost());
        if (properties.getLang() != null && !properties.getLang().isEmpty())
            unimailService.setLang(properties.getLang());
        return unimailService;
    }
}
