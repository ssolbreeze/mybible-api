package com.skyler.mybible_api.common.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "000. OAUTH")
@RestController
public class OauthController {

    @GetMapping("/oauth/kakao")
    public ResponseEntity<?> healthCheck(@RequestParam String code, @RequestParam String error, @RequestParam String error_description ) {
        System.out.println("code="+code);
        System.out.println("error="+error);
        System.out.println("error_description="+error_description);
        return ResponseEntity.ok("OK");
    }

//    @GetMapping("/env")
//    public ResponseEntity<?> getEnv() {
//        return ResponseEntity.ok(env);
//    }
}
