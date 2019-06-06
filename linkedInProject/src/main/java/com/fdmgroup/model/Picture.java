package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "pictures")
public class Picture {

	@Id
	@SequenceGenerator(name = "picture_id", sequenceName = "PICTURE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_id")
	@Column
	private int pictureId;

	@Column(name = "file_path", length=50)
	private String filePath;

	public Picture() {
	}

	public Picture(int pictureId, String filePath) {
		super();
		this.pictureId = pictureId;
		this.filePath = filePath;
	}

	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + pictureId;
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
		Picture other = (Picture) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (pictureId != other.pictureId)
			return false;
		return true;
	}

}
