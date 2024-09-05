package com.HenriqueMundim.github.com.orange_app_api.domain.services.amazon;

import java.net.URL;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

@Service
public class S3Service {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	private static final long EXPIRATION_TIME = 60 * 60 * 1000;
	
	public String generatePresignedUrl(String bucketName, String objectkey, HttpMethod httpMethod) {
		
		Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += EXPIRATION_TIME;
        expiration.setTime(expTimeMillis);
		
		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectkey)
				.withMethod(httpMethod)
				.withExpiration(expiration);
		
		URL url = this.amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
		
		return url.toString();
	}
	
	public void delete(String bucketName, String objectkey) {
		this.amazonS3.deleteObject(bucketName, objectkey);
	}
}
