package com.zhengj.oauth.provider;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import com.zhengj.oauth.OAuthAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class WeiboOAuthProvider extends AbstractOAuthProvider {

    @Component
    @ConfigurationProperties("spring.signin.oauth.weibo")
    public static class OAuthConfiguration extends AbstractOAuthConfiguration {

    }

    @Autowired
    OAuthConfiguration configuration;

    @Override
    public AbstractOAuthConfiguration getOAuthConfiguration() {
        return this.configuration;
    }

    @Override
    public String getAuthenticateUrl(String redirectUrl) {
        try {
            return String.format("https://api.weibo.com/oauth2/authorize?client_id=%s&response_type=%s&redirect_uri=%s",
                    this.configuration.getClientId(), "code", URLEncoder.encode(redirectUrl, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("err is ",e);
            return null;
        }
    }

    @Override
    public OAuthAuthentication getAuthentication(String code, String state, String redirectUrl) throws Exception {
        return null;
    }
}
