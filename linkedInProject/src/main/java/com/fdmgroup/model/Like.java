package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "likes")
public class Like {

	@Id
	@SequenceGenerator(name = "like_id", sequenceName = "LIKE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_id")
	@Column
	private int likeId;

	@Column(name = "thumbs_up")
	private boolean like;

	@ManyToOne
	@JoinColumn(name = "username")
	private User liker;

	public Like() {
	}

	public Like(int likeId, boolean like, User liker) {
		super();
		this.likeId = likeId;
		this.like = like;
		this.liker = liker;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public User getLiker() {
		return liker;
	}

	public void setLiker(User liker) {
		this.liker = liker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (like ? 1231 : 1237);
		result = prime * result + likeId;
		result = prime * result + ((liker == null) ? 0 : liker.hashCode());
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
		Like other = (Like) obj;
		if (like != other.like)
			return false;
		if (likeId != other.likeId)
			return false;
		if (liker == null) {
			if (other.liker != null)
				return false;
		} else if (!liker.equals(other.liker))
			return false;
		return true;
	}

}
