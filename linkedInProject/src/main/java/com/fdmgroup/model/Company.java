package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "companies")
public class Company {

	@Id
	@Column(name = "company_name", length = 26)
	private String companyName;

	@OneToOne
	@JoinColumn(name = "company_logo")
	private Picture companyLogo;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "company_email", length = 50)
	private String companyEmail;
	
	@Column(name = "location", length=40)
	private String location;
	
	@Column(name = "industry", length=40)
	private String industry;
	
	private transient String confirmPassword;

	public Company(){}
	
	public Company(String companyName, Picture companyLogo, String password, String companyEmail, String location,
			String industry) {
		super();
		this.companyName = companyName;
		this.companyLogo = companyLogo;
		this.password = password;
		this.companyEmail = companyEmail;
		this.location = location;
		this.industry = industry;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Picture getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(Picture companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
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
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((companyLogo == null) ? 0 : companyLogo.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Company other = (Company) obj;
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (companyLogo == null) {
			if (other.companyLogo != null)
				return false;
		} else if (!companyLogo.equals(other.companyLogo))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (industry == null) {
			if (other.industry != null)
				return false;
		} else if (!industry.equals(other.industry))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}
