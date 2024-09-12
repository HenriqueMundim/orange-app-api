package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueMundim.github.com.orange_app_api.domain.services.amazon.S3Service;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.PresignedUrl;
import com.amazonaws.HttpMethod;

@RestController
@RequestMapping(value = "/aws")
public class AmazonS3Controller {
	
	private S3Service s3Service;
	
	@Value("${aws.bucket.name}")
	private String bucket;
	
	public AmazonS3Controller(S3Service s3Service) {
		this.s3Service = s3Service;
	}
	
	@GetMapping(value = "/getpresignedurl/upload")
	public ResponseEntity<PresignedUrl> generateUploadUrl(@RequestParam String objectKey) {
		String url = this.s3Service.generatePresignedUrl(bucket, objectKey, HttpMethod.PUT);
		
		return ResponseEntity.status(HttpStatus.OK).body(new PresignedUrl(url));
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> generateDeleteUrl(@RequestParam String objectKey) {
		this.s3Service.delete(bucket, objectKey);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
