package com.aliyun.oss.allyunossspringbootautoconfigure;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliOSSUtilspro.class)
public class AliOSSAutoConfiguration {
    @Bean
    public AliOSSUtils aliOSSUtils(AliOSSUtilspro aliOSSUtilspro) throws ClientException {
        return new AliOSSUtils(aliOSSUtilspro);
    }
}
