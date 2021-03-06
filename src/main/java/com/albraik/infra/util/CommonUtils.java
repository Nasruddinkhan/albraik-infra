package com.albraik.infra.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.core.env.Environment;
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
	public static String checkNull(Object obj) {
		return Optional.ofNullable(obj).map(s -> s.toString()).orElse("");
	}
	public static String uploadFileToS3Bucket(final String bucketName, final File file, AmazonS3 amazonS3, String endPointURL) {
	        final String uniqueFileName = System.currentTimeMillis() + "_" + file.getName();
	        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
	        amazonS3.putObject(putObjectRequest);
	        return endPointURL+"/"+uniqueFileName;
	    }
	
	public static File createDynamicImage(String firstName, Environment env)  {
		int width = 120;
		int height = 120;
		String filePath = env.getProperty("img.location");
		String imgChar = String.valueOf(firstName.charAt(0)).toUpperCase();
		String fileStr = filePath+imgChar+".jpg";
		File file = new File(fileStr);
		if(!file.exists()) {
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Font myFont = new Font ("Courier New", 1, 100);
			Graphics2D g2d = bufferedImage.createGraphics();
			g2d.setFont(myFont);
			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, width, height);
			g2d.setColor(Color.gray);
			g2d.fillOval(0, 0, width, height);
			g2d.setColor(Color.yellow);
			g2d.drawString(imgChar, 35, 85);
			g2d.dispose();
			try {
				ImageIO.write(bufferedImage, "jpg", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public static String generateRandomUserPassword()
	{
		return RandomStringUtils.random(AppConstants.RANDOM_USER_PASSWORD_LENGTH, true, true);
	}
}
