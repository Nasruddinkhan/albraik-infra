package com.albraik.infra.mail.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.albraik.infra.feign.dto.MailDTO;
import com.albraik.infra.feign.service.MailSenderFeignService;
import com.albraik.infra.feign.util.MailConstants;
import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;

@Service
public class MailSenderServiceImpl implements MailSenderService{

	@Autowired
	private MailSenderFeignService mailSenderFeignService;
	
	@Value("${mail.template.admin-register.id}")
	private Integer adminRegisterMailTemplateID;
	
	@Value("${mail.template.user-register.id}")
	private Integer userRegisterMailTemplateID;
	
	
	@Async
	@Override
	public void sendAdminRegisterMail(AdminRegisterRequestDTO adminRegisterRequestDTO, String plainPassword) {
		Map<String, Object> requiredData = new HashMap<>();
		requiredData.put(MailConstants.EMAIL, adminRegisterRequestDTO.getEmail());
		requiredData.put(MailConstants.PASSWORD, plainPassword);
		MailDTO mailDTO = new MailDTO(adminRegisterMailTemplateID, adminRegisterRequestDTO.getEmail(), requiredData);
		mailDTO = mailSenderFeignService.sendMail(mailDTO);
	}
	
	@Async
	@Override
	public void sendUserRegisterMail(UserRegisterRequestDTO userRegisterRequestDTO, String plainPassword) {
		Map<String, Object> requiredData = new HashMap<>();
		requiredData.put(MailConstants.EMAIL, userRegisterRequestDTO.getEmail());
		requiredData.put(MailConstants.PASSWORD, plainPassword);
		MailDTO mailDTO = new MailDTO(userRegisterMailTemplateID, userRegisterRequestDTO.getEmail(), requiredData);
		mailDTO = mailSenderFeignService.sendMail(mailDTO);
	}
	
	
}
