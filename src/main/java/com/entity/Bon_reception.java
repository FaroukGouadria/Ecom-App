package com.entity;

import java.util.Date;

public class Bon_reception {
	private int id;
	private String codeBon,adressereception;
	String fornisseur;
	private String datebon,datereception;
	private Float montantHT;
	private float tva,montantTTC;

	
	public Bon_reception(String codeBon, String adressereception, String fornisseur, String datebon, String datereception,
			Float montantHT, float tva, float montantTTC) {
		super();
		this.codeBon = codeBon;
		this.adressereception = adressereception;
		this.fornisseur = fornisseur;
		this.datebon = datebon;
		this.datereception = datereception;
		this.montantHT = montantHT;
		this.tva = tva;
		this.montantTTC = montantTTC;
	}
	public Bon_reception() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bon_reception(int id, String codeBon, String adressereception, String fornisseur, String datebon,
			String datereception, Float montantHT, float tva, float montantTTC) {
		super();
		this.id = id;
		this.codeBon = codeBon;
		this.adressereception = adressereception;
		this.fornisseur = fornisseur;
		this.datebon = datebon;
		this.datereception = datereception;
		this.montantHT = montantHT;
		this.tva = tva;
		this.montantTTC = montantTTC;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCodeBon() {
		return codeBon;
	}
	public void setCodeBon(String codeBon) {
		this.codeBon = codeBon;
	}
	public String getAdressereception() {
		return adressereception;
	}
	public void setAdressereception(String adressereception) {
		this.adressereception = adressereception;
	}
	public String getFornisseur() {
		return fornisseur;
	}
	public void setFornisseur(String fornisseur) {
		this.fornisseur = fornisseur;
	}
	public String getDatebon() {
		return datebon;
	}
	public void setDatebon(String datebon) {
		this.datebon = datebon;
	}
	public String getDatereception() {
		return datereception;
	}
	public void setDatereception(String datereception) {
		this.datereception = datereception;
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
