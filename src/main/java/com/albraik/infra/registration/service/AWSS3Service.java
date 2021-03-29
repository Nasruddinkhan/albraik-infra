package com.albraik.infra.registration.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	String uploadFile(MultipartFile multipartFile, String bucketName, String endPointUrl, Integer  companyId);

	String uploadFile(File file, String bucketName, String endPointUrl);

}
