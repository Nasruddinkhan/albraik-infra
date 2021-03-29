package com.albraik.infra.feign.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailDTO {
	
	@NotNull
	@JsonProperty("mail_template_id")
	private Integer mailTemplateId;
	
	@NotNull
	@JsonProperty("mail_to")
	private String mailTo;
	
	@JsonProperty("required_data")
	private Map<String, Object> requiredData;
	
	
	public MailDTO(@NotNull Integer mailTemplateId, @NotNull String mailTo, Map<String, Object> requiredData) {
		super();
		this.mailTemplateId = mailTemplateId;
		this.mailTo = mailTo;
		this.requiredData = requiredData;
	}

	public Integer getMailTemplateId() {
		return mailTemplateId;
	}

	public void setMailTemplateId(Integer mailTemplateId) {
		this.mailTemplateId = mailTemplateId;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public Map<String, Object> getRequiredData() {
		return requiredData;
	}

	public void setRequiredData(Map<String, Object> requiredData) {
		this.requiredData = requiredData;
	}
	
}
