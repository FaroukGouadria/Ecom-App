package com.dao;

import java.util.List;

import com.entity.Facture;

public interface FactureDao {

	public boolean ajouterfacture(Facture f);
	public List<Facture> getAllfacture();
	public Facture getfacturebyId(int id);
	public boolean updatefacture(Facture f);
	public boolean deletefacture(int id);
	
}
