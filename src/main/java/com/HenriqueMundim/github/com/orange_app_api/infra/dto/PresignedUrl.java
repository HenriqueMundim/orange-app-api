package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

public class PresignedUrl {
	private String url;
	
	public PresignedUrl() {}
	
	public PresignedUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
