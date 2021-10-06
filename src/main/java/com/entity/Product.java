package com.entity;

public class Product {
	private int id;
	private String name;
	private int price , quantite;
	private String category,photo;
	private String email;
	String fornisseur;
	private int stock_min;
	private int prix_unitaire;
	private float tva_prod;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, int price, int quantite, String category,float tva_prod) {
		super();
		this.name = name;
		this.price = price;
		this.quantite = quantite;
		this.category = category;
		this.tva_prod=tva_prod;
	}

	public Product(int id, String name, int price, int quantite, String category, String photo, String email,
			String fornisseur, int stock_min, int prix_unitaire, float tva_prod) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantite = quantite;
		this.category = category;
		this.photo = photo;
		this.email = email;
		this.fornisseur = fornisseur;
		this.stock_min = stock_min;
		this.prix_unitaire = prix_unitaire;
		this.tva_prod = tva_prod;
	}
	public String getFornisseur() {
		return fornisseur;
	}
	public void setFornisseur(String fornisseur) {
		this.fornisseur = fornisseur;
	}
	public int getStock_min() {
		return stock_min;
	}
	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}
	public int getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	public float getTva_prod() {
		return tva_prod;
	}
	public void setTva_prod(float tva_prod) {
		this.tva_prod = tva_prod;
	}
	public Product(String name, int price, int quantite, String category, String photo, String email, String fournisseur) {
		super();
		this.name = name;
		this.price = price;
		this.quantite = quantite;
		this.category = category;
		this.photo = photo;
		this.email = email;
		this.fornisseur=fournisseur;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
