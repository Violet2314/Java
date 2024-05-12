package com.aliyun.oss.allyunossspringbootautoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSUtilspro {
    private String endpoint;
    private String bucketName;
}
