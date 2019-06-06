package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "messages")
public class Message {

	@Id
	@SequenceGenerator(name = "message_id", sequenceName = "MESSAGE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id")
	@Column
	private int messageId;

	@ManyToOne
	@JoinColumn(name = "connection_id")
	private Connection connectionId;

	@Column(name = "message")
	private String message;

	public Message() {
	}

	public Message(int messageId, Connection connectionId, String message) {
		super();
		this.messageId = messageId;
		this.connectionId = connectionId;
		this.message = message;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Connection getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Connection connectionId) {
		this.connectionId = connectionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionId == null) ? 0 : connectionId.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + messageId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (connectionId == null) {
			if (other.connectionId != null)
				return false;
		} else if (!connectionId.equals(other.connectionId))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageId != other.messageId)
			return false;
		return true;
	}

}
