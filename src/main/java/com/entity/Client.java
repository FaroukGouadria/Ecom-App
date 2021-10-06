package com.entity;

public class Client {
	private int id;
	private String code;
	private String name;
	private String matricule;
	private String adresse;
	private int phone;
	private String email_fc;
	public Client() {
		super();
	}
	public Client(String code,String name, String matricule, String adresse, int phone, String email_fc) {
		super();
		this.code = code;
		this.matricule = matricule;
		this.adresse = adresse;
		this.phone = phone;
		this.email_fc = email_fc;
	}
	public Client(int id, String code,String name, String matricule, String adresse, int phone, String email_fc) {
		super();
		this.id = id;
		this.code = code;
		this.matricule = matricule;
		this.adresse = adresse;
		this.phone = phone;
		this.email_fc = email_fc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail_fc() {
		return email_fc;
	}
	public void setEmail_fc(String email_fc) {
		this.email_fc = email_fc;
	}
}
