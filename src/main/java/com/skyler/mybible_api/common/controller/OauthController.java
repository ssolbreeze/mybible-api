package com.skyler.mybible_api.common.controller;

import com.skyler.mybible_api.config.provider.kakao.KakaoOauth2FeignClient;
import com.skyler.mybible_api.config.provider.kakao.KakaoRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "000. OAUTH")
@RestController
@RequiredArgsConstructor
public class OauthController {

    private final KakaoOauth2FeignClient kakaoOauth2FeignClient;


    @GetMapping("/oauth/kakao")
    public ResponseEntity<?> healthCheck(@RequestParam(required = false) String code, @RequestParam(required = false) String error, @RequestParam(required = false) String error_description ) {
        System.out.println("code="+code);
        System.out.println("error="+error);
        System.out.println("error_description="+error_description);

        Object res = kakaoOauth2FeignClient.getToken(KakaoRequest.builder()
                        .client_id("7672bad521949786b46348249623fd28")
                        .grant_type("authorization_code")
                        .redirect_uri("http://api.ssol-breeze.xyz:8080/oauth/kakao")
                        .code(code)
                .build());

        System.out.println("res="+res);
        return ResponseEntity.ok("OK");
    }

}
