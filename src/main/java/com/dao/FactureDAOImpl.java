package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Facture;

public class FactureDAOImpl implements FactureDao {
	private Connection conn;
	public FactureDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean ajouterfacture(Facture f) {
		boolean ff=false;
		try {
				String sql="INSERT INTO `facture`(`code`, `client`, `adresse`, `date`, `montht`, `tva`, `montantttc`) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, f.getCodefacture());
					ps.setString(2, f.getAdresse());
					ps.setString(3, f.getClient());
					ps.setString(4, f.getDate());
					ps.setFloat(5, f.getMontantHT());
					ps.setFloat(6, f.getTva());
					ps.setFloat(7, f.getMontantTTC());
				int i=ps.executeUpdate();
				
				if(i==1) {
					ff=true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return ff;
	}

	public List<Facture> getAllfacture() {
		List<Facture> l=new ArrayList<Facture>();
		Facture f=null;
		try {
			String sql="SELECT * FROM facture";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Facture();
				f.setId(rs.getInt(1));
				f.setCodefacture(rs.getString(2));
				f.setAdresse(rs.getString(3));
				f.setClient(rs.getString(4));
				f.setDate(rs.getString(5));
				f.setMontantHT(rs.getFloat(6));
				f.setTva(rs.getFloat(7));
				f.setMontantTTC(rs.getFloat(8));
				l.add(f);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return l;
	}

	public Facture getfacturebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatefacture(Facture f) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletefacture(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
