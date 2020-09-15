package com.albraik.infra.mail.service;

import com.albraik.infra.feign.dto.MailDTO;
import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;

public interface MailSenderService {
	
	MailDTO sendAdminRegisterMail(AdminRegisterRequestDTO adminRegisterRequestDTO, String plainPassword);

}
