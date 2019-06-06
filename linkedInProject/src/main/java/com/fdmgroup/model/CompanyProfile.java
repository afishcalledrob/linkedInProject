package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "company_profile_pages")
public class CompanyProfile {

	@Id
	@SequenceGenerator(name = "company_profile_id", sequenceName = "COMPANY_PROFILE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_profile_id")
	@Column
	private int companyProfileId;
	
	@OneToOne
	@JoinColumn(name = "company_name")
	private Company company;

	@Column(name = "summary", length = 140)
	private String summary;

	@Column(name = "about", length = 420)
	private String about;

	public CompanyProfile() {
	}

	public CompanyProfile(Company company, String summary, String about) {
		super();
		this.company = company;
		this.summary = summary;
		this.about = about;
	}

	public Company getcompany() {
		return company;
	}

	public void setcompany(Company company) {
		this.company = company;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		CompanyProfile other = (CompanyProfile) obj;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

}
