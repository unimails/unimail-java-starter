package top.allcloud;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "unimail")
public class UnimailProperties {
    private boolean enabled = true;
    private String host;
    private String key;
    private String language;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @deprecated Use {@link #getLanguage()}.
     */
    @Deprecated
    public String getLangage() {
        return this.language;
    }

    /**
     * @deprecated Use {@link #setLanguage(String)}.
     */
    @Deprecated
    public void setLangage(String langage) {
        this.language = langage;
    }
}
