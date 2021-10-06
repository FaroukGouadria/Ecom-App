package com.entity;

public class Ligne_bon_reception {
private int id,codebon;
private String codeligne;
Product product;
private float prixht;
public Ligne_bon_reception() {
	super();
	// TODO Auto-generated constructor stub
}
public Ligne_bon_reception(int id, String codeligne, int codebon, Product product, float prixht, float tva) {
	super();
	this.id = id;
	this.codeligne = codeligne;
	this.codebon = codebon;
	this.product = product;
	this.prixht = prixht;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCodeligne() {
	return codeligne;
}
public void setCodeligne(String codeligne) {
	this.codeligne = codeligne;
}
public int getCodebon() {
	return codebon;
}
public void setCodebon(int codebon) {
	this.codebon = codebon;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public float getPrixht() {
	return prixht;
}
public void setPrixht(float prixht) {
	this.prixht = prixht;
}

public Ligne_bon_reception(String codeligne, int codebon, Product product, float prixht) {
	super();
	this.codeligne = codeligne;
	this.codebon = codebon;
	this.product = product;
	this.prixht = prixht;
	
}

}
