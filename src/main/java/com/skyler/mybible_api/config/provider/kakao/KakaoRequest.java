package com.skyler.mybible_api.config.provider.kakao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KakaoRequest {
    private String grant_type;
    private String client_id;
    private String code;
    private String redirect_uri;
}
