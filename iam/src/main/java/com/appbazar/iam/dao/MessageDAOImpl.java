package com.appbazar.iam.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.appbazar.iam.entity.Message;

@SuppressWarnings("unchecked")
public class MessageDAOImpl {

	@Autowired
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public long addMessage(Message message) {
		
		message.setCreatedBy(String.valueOf(message.getSrcUserId()));
		message.setUpdatedBy(String.valueOf(message.getSrcUserId()));
		message.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		message.setUpdatedOn(new Timestamp(new java.util.Date().getTime()));
		template.save(message);
		return message.getMsgId();
	}

	public List<Message> getAllMessages(Message message) {
		List<Message> msgList = (List<Message>) template.find("from Message");

		return msgList;
	}

	public List<Message> findMessageById(int messageId) {
		List<Message> msgList = (List<Message>) template.find("from Message where msgId = ?", messageId);

		return msgList;
	}

	public List<Message> findMessageBySourceId(int sourceUserId) {
		List<Message> msgList = (List<Message>) template.find("from Message where srcUserId = ?", sourceUserId);

		return msgList;
	}

	public List<Message> findMessageByDestinationId(int destUserId) {
		List<Message> msgList = (List<Message>) template.find("from Message where destUserId = ?", destUserId);

		return msgList;
	}

}
