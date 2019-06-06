package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "posts")
public class Post {

	@Id
	@SequenceGenerator(name = "post_id", sequenceName = "POST_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id")
	@Column
	private int postId;

	@Column(name = "post_message")
	private String Message;

	@ManyToOne
	@JoinColumn(name = "username")
	private User poster;

	@ManyToMany
	@JoinTable(name = "post_like", joinColumns = @JoinColumn(name = "post_id") , inverseJoinColumns = @JoinColumn(name = "like_id") )
	private List<Like> likes = new ArrayList<Like>();

	public Post() {
	}

	public Post(int postId, String message, User poster, List<Like> likes) {
		super();
		this.postId = postId;
		Message = message;
		this.poster = poster;
		this.likes = likes;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Message == null) ? 0 : Message.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + postId;
		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
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
		Post other = (Post) obj;
		if (Message == null) {
			if (other.Message != null)
				return false;
		} else if (!Message.equals(other.Message))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (postId != other.postId)
			return false;
		if (poster == null) {
			if (other.poster != null)
				return false;
		} else if (!poster.equals(other.poster))
			return false;
		return true;
	}

}
