package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BD.DBconnect;
//import com.BD.DataBaseConnection;
import com.entity.Fournisseur;
import com.entity.Product;

public class FournisseurDaoImpl implements FournisseurDao{
	private Connection conn;
	public FournisseurDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean ajouterfournisseur(Fournisseur f) {
		boolean fa=false;
		try {
					String sql="INSERT INTO `fournisseur`(`code`, `name`, `matricule`, `adresse`, `phone`, `email`) VALUES (?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, f.getCode());
					ps.setString(2, f.getName());
					ps.setString(3, f.getMatricule_fiscale_fc());
					ps.setString(4, f.getAdresse());
					ps.setInt(5, f.getPhone());
					ps.setString(6, f.getEmail_fc());
				int i=ps.executeUpdate();
				
				if(i==1) {
					fa=true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return fa;
	}

	

	public List<Fournisseur> getAllfournisseur() {
		List<Fournisseur> l=new ArrayList<Fournisseur>();
		Fournisseur f=null;
		try {
			String sql="SELECT * FROM `fournisseur`";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Fournisseur();
				f.setId(rs.getInt(1));
				f.setCode(rs.getString(2));
				f.setName(rs.getString(3));
				f.setMatricule_fiscale_fc(rs.getString(4));
				f.setAdresse(rs.getString(5));
				f.setPhone(rs.getInt(6));
				f.setEmail_fc(rs.getString(7));
				l.add(f);
			}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return l;
	}

	public Fournisseur getFournisseurbyId(int id) {
		Fournisseur f=null;
		try {
			String sql="SELECT * FROM `fournisseur` WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Fournisseur();
				f.setId(rs.getInt(1));
				f.setCode(rs.getString(2));
				f.setName(rs.getString(3));
				f.setMatricule_fiscale_fc(rs.getString(4));
				f.setAdresse(rs.getString(5));
				f.setPhone(rs.getInt(6));
				f.setEmail_fc(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

	public boolean updatefournisseur(Fournisseur f) {
		boolean fa=false;
		try {
			String sql="UPDATE `fournisseur` SET `code`=?,`name`=?,`matricule`=?,`adresse`=?,`phone`=?,`email`=? WHERE id=?";   
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, f.getCode());
			ps.setString(2, f.getName());
			ps.setString(3, f.getMatricule_fiscale_fc());
			ps.setString(4, f.getAdresse());
			ps.setInt(5, f.getPhone());
			ps.setString(6, f.getEmail_fc());
			ps.setInt(7, f.getId());
			
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

	public boolean deletefournisseur(int id) {
		boolean f=false;
		try {
			String sql="delete from fournisseur where id=?";
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

	/*public static ResultSet getAllFournisseur() throws SQLException {
		ResultSet rs=null;
		String sql="SELECT * FROM `forniseur`";
		rs=DataBaseConnection.executionQuerry(sql);
		return rs;
	}*/

}
