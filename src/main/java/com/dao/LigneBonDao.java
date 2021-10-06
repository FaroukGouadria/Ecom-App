package com.dao;

import java.util.List;

import com.entity.Ligne_bon_reception;


public interface LigneBonDao {
	
	public boolean ajouterbon(Ligne_bon_reception lb);
	
	public boolean ajouterLignebon(Ligne_bon_reception lb);
	public List<Ligne_bon_reception> getAllproducts();
	public Ligne_bon_reception getBookbyId(int id);
	public boolean updateproduct(Ligne_bon_reception p);
	public boolean deleteprod(int id);
				
}
