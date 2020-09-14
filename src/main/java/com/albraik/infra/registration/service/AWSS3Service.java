package com.albraik.infra.registration.service;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	String uploadFile(MultipartFile multipartFile, String bucketName, String endPointUrl, Integer  companyId);

}
