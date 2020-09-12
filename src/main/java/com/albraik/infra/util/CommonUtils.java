package com.albraik.infra.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

public interface CommonUtils {

	public static File convertMultiPartFileToFile(final MultipartFile multipartFile) {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
		return file;
	}
	
	public static String uploadFileToS3Bucket(final String bucketName, final File file, AmazonS3 amazonS3, String endPointURL) {
	        final String uniqueFileName = System.currentTimeMillis() + "_" + file.getName();
	        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
	        amazonS3.putObject(putObjectRequest);
	        return endPointURL+"/"+uniqueFileName;
	    }
}
