package com.cos.security1.config.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes; // getAttributes();

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public String getProvider() {
        return "kakao";
    }
    @Override
    public String getEmail() {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Boolean needsScopeAgreement = (Boolean) kakaoAccount.get("email_needs_agreement");

        if (needsScopeAgreement) {
            return null;
        }

        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getName() {
        Map<String, Object> profile = (Map<String, Object>) attributes.get("profile");
        return (String) profile.get("nickname");
    }

}
