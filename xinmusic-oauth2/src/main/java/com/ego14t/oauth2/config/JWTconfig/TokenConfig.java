package com.ego14t.oauth2.config.JWTconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/16 10:40
 * Description:
 */
@Configuration
public class TokenConfig {

    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("mykey.jks"), "shuaibxin666".toCharArray());
        return keyStoreKeyFactory.getKeyPair("ego1st", "shuaibxin666".toCharArray());
    }
}
