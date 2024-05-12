package com.aliyun.oss.allyunossspringbootautoconfigure;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */

public class AliOSSUtils {


    private AliOSSUtilspro aliOSSUtilspro;

    public AliOSSUtils(AliOSSUtilspro aliOSSUtilspro) throws ClientException {
        this.aliOSSUtilspro = aliOSSUtilspro;
    }

    //    //@Value("${aliyun.oss.endpoint}")
//    private String endpoint = aliOSSUtilspro.getEndpoint();//不能在这里进行取注入中的值，因为这个时候还没注入，是空的
    EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
//    //@Value("${aliyun.oss.bucketName}")
//    private String bucketName = aliOSSUtilspro.getBucketName();

    public AliOSSUtils() throws ClientException {
    }

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException, ClientException {
        // 获取上传的文件的输入流
        String endpoint = aliOSSUtilspro.getEndpoint();//要在这里才可以
        String bucketName = aliOSSUtilspro.getBucketName();
        //EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }
}
