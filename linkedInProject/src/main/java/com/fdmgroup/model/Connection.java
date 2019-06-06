package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "connections")
public class Connection {

	@Id
	@SequenceGenerator(name = "connection_id", sequenceName = "CONNECTION_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "connection_id")
	@Column
	private int connectionId;

	@ManyToOne
    @JoinTable(name = "senders", joinColumns = @JoinColumn(name = "connection_id") , inverseJoinColumns = @JoinColumn(name = "username") )
    private User user1;

    @ManyToOne
    @JoinTable(name = "recievers", joinColumns = @JoinColumn(name = "connection_id") , inverseJoinColumns = @JoinColumn(name = "username") )
    private User user2;

    @Column(name = "ratified")
    private boolean ratified;

	public Connection() {
	}

	public Connection(int connectionId, User user1, User user2, boolean ratified) {
		super();
		this.connectionId = connectionId;
		this.user1 = user1;
		this.user2 = user2;
		this.ratified = ratified;
	}

	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public boolean isRatified() {
		return ratified;
	}

	public void setRatified(boolean ratified) {
		this.ratified = ratified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + connectionId;
		result = prime * result + (ratified ? 1231 : 1237);
		result = prime * result + ((user1 == null) ? 0 : user1.hashCode());
		result = prime * result + ((user2 == null) ? 0 : user2.hashCode());
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
		Connection other = (Connection) obj;
		if (connectionId != other.connectionId)
			return false;
		if (ratified != other.ratified)
			return false;
		if (user1 == null) {
			if (other.user1 != null)
				return false;
		} else if (!user1.equals(other.user1))
			return false;
		if (user2 == null) {
			if (other.user2 != null)
				return false;
		} else if (!user2.equals(other.user2))
			return false;
		return true;
	}	

}
