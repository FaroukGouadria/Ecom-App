package com.dao;

import java.util.List;

import com.entity.Ligne_Facture_Client;

public interface LigneFactureDAO {
	public boolean ajouterLignefacture(Ligne_Facture_Client lfc);
	public List<Ligne_Facture_Client> getAllligne();
	public Ligne_Facture_Client getlignebyId(int id);
	public boolean updateligne(Ligne_Facture_Client lfc);
	public boolean deleteligne(int id);
}
