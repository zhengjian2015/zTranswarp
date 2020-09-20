package com.zhengj.oauth;

import com.zhengj.oauth.provider.AbstractOAuthConfiguration;
import com.zhengj.oauth.provider.AbstractOAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OAuthProviders {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    List<AbstractOAuthProvider> allOAuthProviders;

    List<AbstractOAuthProvider> enabledOAuthProviders;

    Map<String, AbstractOAuthProvider> enabledOAuthProviderMap;

    Map<String, AbstractOAuthConfiguration> enabledOAuthConfigurationMap;

    @PostConstruct
    public void init() {
        this.enabledOAuthProviders = this.allOAuthProviders.stream().filter(p -> p.isEnabled())
                .collect(Collectors.toList());
        this.enabledOAuthProviderMap = this.enabledOAuthProviders.stream().map(p -> {
            logger.info("Found OAuth provider: " + p.getProviderId());
            return p;
        }).collect(Collectors.toMap(AbstractOAuthProvider::getProviderId, p -> p));

        Map<String, AbstractOAuthConfiguration> map = new LinkedHashMap<>();
        this.enabledOAuthProviders.stream()
                .map(provider -> new OAuthInfo(provider.getProviderId(), provider.getOAuthConfiguration())).sorted()
                .forEach(oi -> {
                    map.put(oi.oauthProviderId, oi.oauthConfiguration);
                });
        this.enabledOAuthConfigurationMap = map;
    }

    public List<AbstractOAuthProvider> getOAuthProviders() {
        return this.enabledOAuthProviders;
    }

    public Map<String, AbstractOAuthConfiguration> getOAuthConfigurations() {
        return this.enabledOAuthConfigurationMap;
    }

    static class OAuthInfo implements Comparable<OAuthInfo> {
        final String oauthProviderId;
        final AbstractOAuthConfiguration oauthConfiguration;

        OAuthInfo(String oauthProviderId, AbstractOAuthConfiguration oauthConfiguration) {
            this.oauthProviderId = oauthProviderId;
            this.oauthConfiguration = oauthConfiguration;
        }

        @Override
        public int compareTo(OAuthInfo o) {
            return this.oauthConfiguration.getName().compareTo(o.oauthConfiguration.getName());
        }
    }
}
