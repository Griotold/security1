package com.cos.security1.config.auth;

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Security Session => Authentication => UserDetails (PrincipalDetails)
public class PrincipalDetails implements UserDetails {

    private User user; // composition

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 권한을 리턴하는 함수
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        // 자바 8 방식을 사용해도 되는데 아직 공부가 부족하니 이대로 가자.
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 1년 동안 로그인 안했으면 휴면 계정으로 만들어 줄 때 사용
    @Override
    public boolean isEnabled() {
        return true;
    }
}
