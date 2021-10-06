package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Bon_reception;
import com.entity.Facture;

public class BonreceptionDaoImpl implements BonreceptionDao {
	private Connection conn;
	
	public BonreceptionDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean ajouterbon(Bon_reception b) {
		boolean f=false;
	try {
			String sql="INSERT INTO `bon_reception`(`code`, `adresse`, `fournisseur`, `date_bon`, `date_rec`, `montantht`, `tva`, `montantttc`) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, b.getCodeBon());
				ps.setString(2, b.getAdressereception());
				ps.setString(3, b.getFornisseur());
				ps.setString(4, b.getDatebon());
				ps.setString(5, b.getDatebon());
				ps.setFloat(6, b.getMontantHT());
				ps.setFloat(7, b.getTva());
				ps.setFloat(8, b.getMontantTTC());
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
return f;
}
	

	public List<Bon_reception> getAllbon() {
		List<Bon_reception> l=new ArrayList<Bon_reception>();
		Bon_reception b=null;
		try {
			String sql="SELECT * FROM bon_reception";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Bon_reception();
				b.setId(rs.getInt(1));
				b.setCodeBon(rs.getString(2));
				b.setAdressereception(rs.getString(3));
				b.setFornisseur(rs.getString(4));
				b.setDatebon(rs.getString(5));
				b.setDatereception(rs.getString(6));
				b.setMontantHT(rs.getFloat(7));
				b.setTva(rs.getFloat(8));
				b.setMontantTTC(rs.getFloat(9));
				l.add(b);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return l;
	}

	public Bon_reception getbonbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatebon(Bon_reception p) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletebon(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
