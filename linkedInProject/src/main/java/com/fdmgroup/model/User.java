package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="users")
public class User {

	@Id
	@Column(name = "username", length = 26)
	private String username;

	@OneToOne
	@JoinColumn(name = "picture_id")
	private Picture profilePic;

	@Column(name = "firstname", length = 10)
	private String firstname;

	@Column(name = "lastname", length = 15)
	private String lastname;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "email", length = 50)
	private String email;
	
	@Column( name = "is_recruiter")
	private boolean isRecruiter;

	private transient String confirmPassword;

	public User() {
	}

	public User(String username, Picture profilePic, String firstname, String lastname, String password, String email,
			boolean isRecruiter) {
		super();
		this.username = username;
		this.profilePic = profilePic;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.isRecruiter = isRecruiter;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Picture getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Picture profilePic) {
		this.profilePic = profilePic;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecruiter() {
		return isRecruiter;
	}

	public void setRecruiter(boolean isRecruiter) {
		this.isRecruiter = isRecruiter;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (isRecruiter ? 1231 : 1237);
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profilePic == null) ? 0 : profilePic.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (isRecruiter != other.isRecruiter)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profilePic == null) {
			if (other.profilePic != null)
				return false;
		} else if (!profilePic.equals(other.profilePic))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

}
