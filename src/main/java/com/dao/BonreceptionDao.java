package com.dao;

import java.util.List;

import com.entity.Bon_reception;;

public interface BonreceptionDao {
	public boolean ajouterbon(Bon_reception b);
	public List<Bon_reception> getAllbon();
	public Bon_reception getbonbyId(int id);
	public boolean updatebon(Bon_reception p);
	public boolean deletebon(int id);
}
