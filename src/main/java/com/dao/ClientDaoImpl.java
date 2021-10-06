package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Client;

public class ClientDaoImpl implements ClientDao {
	private Connection conn;
	public ClientDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean ajouterClient(Client c) {
		boolean fa=false;
		try {
					String sql="INSERT INTO `client`(`code`, `name`, `matricule`, `adresse`, `phone`, `email`) VALUES (?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, c.getCode());
					ps.setString(2, c.getName());
					ps.setString(3, c.getMatricule());
					ps.setString(4, c.getAdresse());
					ps.setInt(5, c.getPhone());
					ps.setString(6, c.getEmail_fc());
				int i=ps.executeUpdate();
				
				if(i==1) {
					fa=true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return fa;
	}

	

	public List<Client> getAllClient() {
		List<Client> l=new ArrayList<Client>();
		Client c=null;
		try {
			String sql="SELECT * FROM `client`";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Client();
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setMatricule(rs.getString(4));
				c.setAdresse(rs.getString(5));
				c.setPhone(rs.getInt(6));
				c.setEmail_fc(rs.getString(7));
				l.add(c);
			}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return l;
	}

	public Client getClientbyId(int id) {
		Client c=null;
		try {
			String sql="SELECT * FROM `client` WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Client();
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setMatricule(rs.getString(4));
				c.setAdresse(rs.getString(5));
				c.setPhone(rs.getInt(6));
				c.setEmail_fc(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return c;
	}

	public boolean updateClient(Client c) {
		boolean fa=false;
		try {
			String sql="UPDATE `client` SET `code`=?,`name`=?,`matricule`=?,`adresse`=?,`phone`=?,`email`=? WHERE id=?";   
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCode());
			ps.setString(2, c.getName());
			ps.setString(3, c.getMatricule());
			ps.setString(4, c.getAdresse());
			ps.setInt(5, c.getPhone());
			ps.setString(6, c.getEmail_fc());
			ps.setInt(7, c.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				fa=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return fa;
	}

	public boolean deleteClient(int id) {
		boolean f=false;
		try {
			String sql="delete from client where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
