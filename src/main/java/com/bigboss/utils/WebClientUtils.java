package com.bigboss.utils;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.Collections;
import java.util.Map;

public class WebClientUtils {

    public static <T> T doHttpRequest(String url, Map<String, String> queryParams, Class<T> clazz, HttpMethod httpMethod) {
        return doHttpRequest(url, queryParams, null, clazz, httpMethod, null, null);
    }

    public static <T> T doHttpRequest(String url, Object params, Class<T> clazz, String contentType, HttpMethod httpMethod) {
        return doHttpRequest(url, null, params, clazz, httpMethod, contentType, null);
    }

    public static <T> T doHttpRequest(String url, Map<String, String> queryParams, Object params, Class<T> clazz, String contentType, HttpMethod httpMethod) {
        return doHttpRequest(url, queryParams, params, clazz, httpMethod, contentType, null);
    }

    /**
     * HTTP 请求
     *
     * @param url         url
     * @param queryParams url参数
     * @param params      JSON参数
     * @param clazz       转换对象
     * @param httpMethod  请求方法
     * @param contentType 内容类型
     * @param headers     请求头
     * @param <T>         返回对象类型
     * @return 返回对象
     */
    public static <T> T doHttpRequest(String url, Map<String, String> queryParams, Object params, Class<T> clazz, HttpMethod httpMethod, String contentType,
                                      HttpHeaders headers) {
        HttpClient httpClient = HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(3))
                        .addHandlerLast(new WriteTimeoutHandler(3)));
        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        WebClient webClient = WebClient.builder().clientConnector(connector).build();
        WebClient.RequestBodyUriSpec requestBodyUriSpec;
        UriBuilder uriBuilder = new DefaultUriBuilderFactory().uriString(url);
        if (null != queryParams) {
            MultiValueMap<String, String> doQueryParams = new LinkedMultiValueMap<>();
            queryParams.forEach((key, value) -> doQueryParams.put(key, Collections.singletonList(value)));
            uriBuilder.queryParams(doQueryParams);
        }
        if (null == httpMethod) {
            requestBodyUriSpec = webClient.method(HttpMethod.GET);
        } else {
            requestBodyUriSpec = webClient.method(httpMethod);
        }
        if (null != contentType) {
            requestBodyUriSpec.contentType(MediaType.valueOf(contentType));
        }
        if (null != headers) {
            requestBodyUriSpec.headers(httpHeaders -> httpHeaders = headers);
        }
        requestBodyUriSpec.uri(uriBuilder.build());
        Mono<T> result = requestBodyUriSpec.bodyValue(params).retrieve().bodyToMono(clazz);
        return result.block();
    }
}
