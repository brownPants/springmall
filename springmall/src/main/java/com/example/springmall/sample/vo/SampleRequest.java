package com.example.springmall.sample.vo;

import org.springframework.web.multipart.MultipartFile;

public class SampleRequest {

	private String sampleId;
	private String samplePw;
	private MultipartFile multipartFile;
	private String sampleFilePath;
	
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}
	public String getSamplePw() {
		return samplePw;
	}
	public void setSamplePw(String samplePw) {
		this.samplePw = samplePw;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getSampleFilePath() {
		return sampleFilePath;
	}
	public void setSampleFilePath(String sampleFilePath) {
		this.sampleFilePath = sampleFilePath;
	}
	@Override
	public String toString() {
		return "SampleRequest [sampleId=" + sampleId + ", samplePw=" + samplePw + ", multipartFile=" + multipartFile
				+ ", sampleFilePath=" + sampleFilePath + "]";
	}
	
}
