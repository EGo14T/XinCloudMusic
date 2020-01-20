package com.ego14t.oauth2.config.JWTconfig;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/20 10:51
 * Description:
 */

@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication =
                super.extractAuthentication(claims);
        authentication.setDetails(claims);
        return authentication;
    }
}
