package com.ego14t.oauth2.config.JWTconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.util.Arrays;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/16 10:40
 * Description:
 */
@Configuration
public class TokenConfig {

    @Resource
    private RedisConnectionFactory connectionFactory;

    @Resource
    private JwtAccessTokenConverter accessTokenConverter;

    @Resource
    private CustomTokenEnhancer customTokenEnhancer;

    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("mykey.jks"), "shuaibxin666".toCharArray());
        return keyStoreKeyFactory.getKeyPair("ego1st", "shuaibxin666".toCharArray());
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair());
        return converter;
    }


    /**
     * 设置token的存储方式 以及 令牌的有效时间
     * @return
     */
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(customTokenEnhancer, accessTokenConverter));

        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setReuseRefreshToken(false);
        defaultTokenServices.setAccessTokenValiditySeconds(86400);
        defaultTokenServices.setRefreshTokenValiditySeconds(604800);

        return defaultTokenServices;
    }
}
