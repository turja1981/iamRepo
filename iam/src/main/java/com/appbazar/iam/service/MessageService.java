package com.appbazar.iam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.appbazar.iam.dao.MessageDAOImpl;
import com.appbazar.iam.entity.Message;

public class MessageService {

	@Autowired
	private MessageDAOImpl messageDAO;

	
	public long addMessage(Message message) {

		return messageDAO.addMessage(message);

	}

	public List<Message> getAllMessages(Message message) {

		return messageDAO.getAllMessages(message);
	}

	public List<Message> getMessageById(Message message) {

		return messageDAO.findMessageById(message.getMsgId());
	}

	public void setMessageDAO(MessageDAOImpl messageDAO) {
		this.messageDAO = messageDAO;
	}

	public List<Message> getMessageBySourceUserId(Message message) {

		return messageDAO.findMessageBySourceId(message.getSrcUserId());
	}

	public List<Message> getMessageByDestinationUserId(Message message) {

		return messageDAO.findMessageByDestinationId(message.getDestUserId());
	}

}
