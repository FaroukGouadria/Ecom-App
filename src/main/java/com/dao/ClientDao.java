package com.dao;

import java.util.List;

import com.entity.Client;

public interface ClientDao {

	
	public boolean ajouterClient(Client c);
	public List<Client> getAllClient();
	public Client getClientbyId(int id);
	public boolean updateClient(Client c);
	public boolean deleteClient(int id);
	
}
