package com.ego14t.oauth2.config;

import com.ego14t.oauth2.config.JWTconfig.CustomTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import java.util.Arrays;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 09:43
 * Description:
 */

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {


    @Resource
    private AuthenticationManager authenticationManager;

    @Resource DefaultTokenServices defaultTokenServices;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder().encode("secret"))
                // 授权类型
                .authorizedGrantTypes("password","refresh_token")
                // 授权范围
                .scopes("all");
                //.accessTokenValiditySeconds(20)
                // 注册回调地址
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /*
         *  /oauth/authorize : 授权端点
         *  /oauth/token : 令牌端点
         *  /oauth/confirm_access : 用户确认授权提交端点
         *  /oauth/error : 授权服务错误信息端点
         *  /oauth/check_token : 用于资源服务访问的令牌解析端点
         *  /oauth/token_key : 提供公钥的端点，如果使用的是JWT令牌。
         *
         */
        security
                .tokenKeyAccess("permitAll()")    // 公钥公开
                .checkTokenAccess("isAuthenticated()")    // 检测token公开
                .allowFormAuthenticationForClients();    // 表单认证

    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .tokenServices(defaultTokenServices)
                .authenticationManager(authenticationManager);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }
}
