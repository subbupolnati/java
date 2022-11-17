package com.rest.model;
//This Response Model class Stores Response Data
public class Response {
	private String lat;//This field will store latitude
	private String lng;//This field will store langutitude
	private String company_name;//This field will store companyName
	private String title;//This field will store post title
	private String body;//This field will store post body
	//No-argument or default constructor
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Arguments constructor with fields
	public Response(String lat, String lng, String company_name, String title, String body) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.company_name = company_name;
		this.title = title;
		this.body = body;
	}
	//Getter and Setters Methods
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	//To string Methods
	@Override
	public String toString() {
		return "Response [lat=" + lat + ", lng=" + lng + ", company_name=" + company_name + ", title=" + title
				+ ", body=" + body + "]";
	}
	

}
