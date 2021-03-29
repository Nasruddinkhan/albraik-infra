package com.albraik.infra.mail.service;

import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;

public interface MailSenderService {
	
	void sendAdminRegisterMail(AdminRegisterRequestDTO adminRegisterRequestDTO, String plainPassword);
	
	void sendUserRegisterMail(UserRegisterRequestDTO adminRegisterRequestDTO, String plainPassword);

}
