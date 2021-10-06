package com.entity;

public class Ligne_Facture_Client {
	private int id;
	private String codeligne;
	private int codefacture;
	private String name;
	private int price, quantite;
	private float tva;
	private float prixht;
	public Ligne_Facture_Client( String codeligne,int codefacture, String name, int price, int quantite, float tva,
			float prixht) {
		super();
		this.codeligne = codeligne;
		this.codefacture = codefacture;
		this.name = name;
		this.price = price;
		this.quantite = quantite;
		this.tva = tva;
		this.prixht = prixht;
	}
	public Ligne_Facture_Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodefacture() {
		return codefacture;
	}
	public void setCodefacture(int codefacture) {
		this.codefacture = codefacture;
	}
	public String getCodeligne() {
		return codeligne;
	}
	public void setCodeligne(String codeligne) {
		this.codeligne = codeligne;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	public float getPrixht() {
		return prixht;
	}
	public void setPrixht(float prixht) {
		this.prixht = prixht;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

	
}
