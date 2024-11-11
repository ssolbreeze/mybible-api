package com.skyler.mybible_api.config.provider.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "KakaoOauth2FeignClient", url = "https://kauth.kakao.com", configuration = KakaoOAuth2FeignConfig.class)
public interface KakaoOauth2FeignClient {

    @PostMapping(value = "/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Object getToken(@RequestBody KakaoRequest req);

}
