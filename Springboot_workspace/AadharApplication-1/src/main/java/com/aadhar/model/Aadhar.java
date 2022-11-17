package com.aadhar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="aadharcard")
public class Aadhar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String aadharNumber;
	@Column
	private String name;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
   // private Byte[] image;
	private String image;
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public Byte[] getImage() { return image; } public void setImage(Byte[]
	 * byteObjects) { this.image = byteObjects; }
	 */

	
	 public String getImage() {
		 return image; 
	 } 
	 public void setImage(String image)
	 { this.image = image; }
	/*
	 * public String getPhotosImagePath() { if (image == null || aadharNumber==
	 * null) return null;
	 * 
	 * return "/user-photos/" + aadharNumber + "/" + image; }
	 */
	

}
