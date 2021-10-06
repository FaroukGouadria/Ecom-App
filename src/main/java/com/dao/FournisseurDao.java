package com.dao;

import java.util.List;

import com.entity.Fournisseur;;

public interface FournisseurDao {

	
		
		public boolean ajouterfournisseur(Fournisseur f);
		public List<Fournisseur> getAllfournisseur();
		public Fournisseur getFournisseurbyId(int id);
		public boolean updatefournisseur(Fournisseur f);
		public boolean deletefournisseur(int id);

	
}
