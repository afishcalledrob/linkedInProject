package com.fdmgroup.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "comments")
public class Comment {

	@Id
	@SequenceGenerator(name = "comment_id", sequenceName = "COMMENT_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id")
	@Column
	private int commentId;

	@ManyToOne
	@JoinColumn(name = "username")
	private User commenter;

	@Column(name = "comment_text", length = 140)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post commentedPost;

	public Comment() {
	}

	public Comment(int commentId, User commenter, String comment, Post commentedPost) {
		super();
		this.commentId = commentId;
		this.commenter = commenter;
		this.comment = comment;
		this.commentedPost = commentedPost;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getCommentedPost() {
		return commentedPost;
	}

	public void setCommentedPost(Post commentedPost) {
		this.commentedPost = commentedPost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + commentId;
		result = prime * result + ((commentedPost == null) ? 0 : commentedPost.hashCode());
		result = prime * result + ((commenter == null) ? 0 : commenter.hashCode());
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
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId != other.commentId)
			return false;
		if (commentedPost == null) {
			if (other.commentedPost != null)
				return false;
		} else if (!commentedPost.equals(other.commentedPost))
			return false;
		if (commenter == null) {
			if (other.commenter != null)
				return false;
		} else if (!commenter.equals(other.commenter))
			return false;
		return true;
	}

}

