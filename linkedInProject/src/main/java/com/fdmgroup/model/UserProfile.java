package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "user_profile_pages")
public class UserProfile{
	
	@Id
	@SequenceGenerator(name = "user_profile_id", sequenceName = "USER_PROFILE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_id")
	@Column
	private int userProfileId;
	
	@OneToOne
	@JoinColumn(name = "username")
	private User user;

	@Column(name = "summary", length = 140)
	private String summary;

	@Column(name = "work_experience", length=420)
	private String about;
	
	@Column(name = "education_experience", length=420)
	private String educationExperience;

	@Column(name = "hobbies", length=420)
	private String hobbies;
	
	@Column(name = "skills", length=420)
	private String skills;
	
	public UserProfile(){}

	public UserProfile(User user, String summary, String about, String educationExperience, String hobbies,
			String skills) {
		super();
		this.user = user;
		this.summary = summary;
		this.about = about;
		this.educationExperience = educationExperience;
		this.hobbies = hobbies;
		this.skills = skills;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEducationExperience() {
		return educationExperience;
	}

	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result + ((educationExperience == null) ? 0 : educationExperience.hashCode());
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserProfile other = (UserProfile) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (educationExperience == null) {
			if (other.educationExperience != null)
				return false;
		} else if (!educationExperience.equals(other.educationExperience))
			return false;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}	

}
