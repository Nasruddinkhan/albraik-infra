package com.albraik.infra.registration.service;


import static com.albraik.infra.util.CommonUtils.convertMultiPartFileToFile;
import static com.albraik.infra.util.CommonUtils.uploadFileToS3Bucket;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;

@Service("awsS3service")
public class AWSS3ServiceImpl implements AWSS3Service {
    private AmazonS3 amazonS3;
    @Autowired
    public AWSS3ServiceImpl(final AmazonS3 amazonS3) {
		super();
		this.amazonS3 = amazonS3;
	}

	@Override
    @Async
    public String uploadFile(final MultipartFile multipartFile, String bucketName, String endPointUrl ) {
		final File file = convertMultiPartFileToFile(multipartFile);
		String returnURL = uploadFileToS3Bucket(bucketName, file, amazonS3, endPointUrl);
		file.delete();
		return returnURL;
	}
 
}
