package com.ego14t.oauth2.entity;

import com.ego14t.common.entity.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/19 17:12
 * Description:
 */
public class UserLogin extends BaseEntity implements UserDetails, Serializable {

    private String username;

    private String password;

    private static final long serialVersionUID = -6021695742877202347L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    // 账户是否过期,过期无法验证
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否被禁用,禁用的用户不能身份验证
    @Override
    public boolean isEnabled() {
        return true;
    }
}
