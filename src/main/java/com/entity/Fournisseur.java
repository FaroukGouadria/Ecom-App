package com.entity;

public class Fournisseur {

	private int id;
	private String code;
	private String name,matricule_fiscale_fc;
	public Fournisseur(int id, String code,String name, String matricule_fiscale_fc, String adresse, int phone, String email_fc) {
		super();
		this.id = id;
		this.code = code;
		this.name=name;
		this.matricule_fiscale_fc = matricule_fiscale_fc;
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
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String code,String name, String matricule_fiscale_fc, String adresse, int phone, String email_fc) {
		super();
		this.code = code;
		this.name=name;
		this.matricule_fiscale_fc = matricule_fiscale_fc;
		this.adresse = adresse;
		this.phone = phone;
		this.email_fc = email_fc;
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
	public String getMatricule_fiscale_fc() {
		return matricule_fiscale_fc;
	}
	public void setMatricule_fiscale_fc(String matricule_fiscale_fc) {
		this.matricule_fiscale_fc = matricule_fiscale_fc;
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
	private String adresse;
	private int phone;
	private String email_fc;

}
