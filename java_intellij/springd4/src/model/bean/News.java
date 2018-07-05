package model.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class News {
	private int id;
	@NotBlank(message="tên không được rỗng")//@NotEmpty
	private String name;
	@NotBlank(message="mô tả không dc rỗng")
	@Size(min=3, max=20, message="nhập vào từ 3 đến 20 kí tự")
	private String description;
	@NotBlank(message="chi tiết không được rỗng")
	private String detail;
	private String picture;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public News(int id, String name, String description, String detail, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
	}
	public News() {
		super();
	}
	public String toString() {
		return "Name:" +name+"\nMô tả:" +description+ "\nDetail" +detail+"\nPicture:" +picture;
	}
	
	
}
