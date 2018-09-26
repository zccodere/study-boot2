package com.zccoder.boot2.ch10.rest.conf;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <br>
 * 标题: Rest配置<br>
 * 描述: Rest配置<br>
 * 时间: 2018/09/26<br>
 *
 * @author zc
 */
@Configuration
public class RestConf implements RestTemplateCustomizer {

    @Override
    public void customize(RestTemplate restTemplate) {
        OkHttp3ClientHttpRequestFactory okHttp = (OkHttp3ClientHttpRequestFactory) restTemplate.getRequestFactory();
        okHttp.setReadTimeout(5000);
        okHttp.setWriteTimeout(3000);
    }

}
