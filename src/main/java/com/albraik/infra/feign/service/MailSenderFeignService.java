package com.albraik.infra.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.albraik.infra.feign.dto.MailDTO;

@FeignClient(name = "mail-sender", path = "/mail-sender")
public interface MailSenderFeignService {

	@PostMapping("/mail")
	MailDTO sendMail(@RequestBody MailDTO mailDTO);
}
