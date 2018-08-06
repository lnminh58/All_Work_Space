package com.jfreedom.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity

@Table(name ="tb_shop")
@NamedQuery(name = "Shop.findAllShop", query = "SELECT s FROM Shop s ")
public class Shop implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="local")
	private String local;

	private String email;
	@Column(name = "date")
	private Date date;

	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "shop")
	private List<Custommer> listcustommers;

	public List<Custommer> getCustommers(){
		return listcustommers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	

	
	public Shop() {
	
	}
	
	@Override
	 public String toString() {
	        return "Shop id=" + id + ", name =" + name + "email=" + email;
	                
	    }
}
