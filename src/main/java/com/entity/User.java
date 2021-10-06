package com.entity;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String adress;
	private String password;
	private String city;
	private String state;
	private String terme;
	public User(int id, String name, String email, String phone, String adress, String password, String city,
			String state, String terme) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.password = password;
		this.city = city;
		this.state = state;
		this.terme = terme;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTerme() {
		return terme;
	}
	public void setTerme(String terme) {
		this.terme = terme;
	}
	public User() {
		super();
	}
	
	
	

}
