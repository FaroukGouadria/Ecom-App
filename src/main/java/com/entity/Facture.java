package com.entity;

public class Facture {
	private int id;
	private String codefacture,adresse;
	String client;
	private String date;
	private Float montantHT;
	private float tva,montantTTC;
	
	
	
	public Facture(String codefacture, String adresse, String client, String date, Float montantHT, float tva,
			float montantTTC) {
		super();
		this.codefacture = codefacture;
		this.adresse = adresse;
		this.client = client;
		this.date = date;
		this.montantHT = montantHT;
		this.tva = tva;
		this.montantTTC = montantTTC;
	}
	public Facture(int id, String codefacture, String adresse, String client, String date, Float montantHT, float tva,
			float montantTTC) {
		super();
		this.id = id;
		this.codefacture = codefacture;
		this.adresse = adresse;
		this.client = client;
		this.date = date;
		this.montantHT = montantHT;
		this.tva = tva;
		this.montantTTC = montantTTC;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodefacture() {
		return codefacture;
	}
	public void setCodefacture(String codefacture) {
		this.codefacture = codefacture;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getMontantHT() {
		return montantHT;
	}
	public void setMontantHT(Float montantHT) {
		this.montantHT = montantHT;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	public float getMontantTTC() {
		return montantTTC;
	}
	public void setMontantTTC(float montantTTC) {
		this.montantTTC = montantTTC;
	}
	
}
