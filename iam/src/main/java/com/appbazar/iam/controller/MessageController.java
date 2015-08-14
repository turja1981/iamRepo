package com.appbazar.iam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appbazar.iam.service.MessageService;


@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	
	

}
