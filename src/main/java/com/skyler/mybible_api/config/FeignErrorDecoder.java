package com.skyler.mybible_api.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
        log.info(">>>>> CommonFeignError <<<<<");
        log.info("method key = {}, response = {}", methodKey, response);
        log.info("res = {}", readResponseBody(response));

        throw new Exception("핀에러");

    }

    public String readResponseBody(Response response) {
        if (response.body() != null) {
            try (InputStream inputStream = response.body().asInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

                // Stream을 이용해 전체 데이터를 String으로 변환
                return reader.lines().collect(Collectors.joining("\n"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
