package com.HenriqueMundim.github.com.orange_app_api.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfig {
	
	@Value("aws.access.key.id")
	private String accessKeyId;
	
	@Value("aws.access.key.secret")
	private String accessKeySecret;
	
	@Value("aws.region.name")
	private String region;

    @Bean
    AmazonS3 amazonS3() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
		
		return AmazonS3ClientBuilder.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
	}

}
