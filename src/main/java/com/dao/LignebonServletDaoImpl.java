package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Ligne_bon_reception;
import com.entity.Product;
import com.BD.*;
public class LignebonServletDaoImpl implements LigneBonDao {
	private Connection conn;
	
	public LignebonServletDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean ajouterbon(Ligne_bon_reception lb) {
		boolean f=false;
		try {
				String sql="INSERT INTO `lignebonreception`(`codeligne`, `codebon`, `name`, `price`, `quantite`, `tva`, `category`,`Montantht`) VALUES (?,?,?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, lb.getCodeligne());
					ps.setInt(2, lb.getCodebon());
					ps.setString(3, lb.getProduct().getName());
					ps.setInt(4, lb.getProduct().getPrice());
					ps.setInt(5, lb.getProduct().getQuantite());
					ps.setFloat(6, lb.getProduct().getTva_prod());
					ps.setString(7, lb.getProduct().getCategory());
					ps.setFloat(8, lb.getPrixht());
				int i=ps.executeUpdate();
					
				if(i==1) {
					f=true;
				}
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return f;
	}
	public boolean ajouterLignebon(Ligne_bon_reception lb) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Ligne_bon_reception> getAllproducts() {
		// TODO Auto-generated method stub
		return null;
	}
	public Ligne_bon_reception getBookbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean updateproduct(Ligne_bon_reception p) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteprod(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void remplircodebon(Ligne_bon_reception lb,int id)  {
			conn=DBconnect.getConn();
		try {
		PreparedStatement ps=conn.prepareStatement("SELECT SUM(`tva`) as totaltva,SUM(`Montantht`) as montant FROM `lignebonreception` WHERE `codebon`='"+ id +"'");
		 System.out.println(ps);
		 ResultSet	 rs = ps.executeQuery();
		if(rs.next())
		 {	
			 try {
			 float tvaa=Float.valueOf(rs.getFloat("totaltva"));
			 System.out.println(tvaa);

			 int montant=Integer.valueOf(rs.getInt("montant"));
			 System.out.println(montant);
			 float mttc=tvaa*montant;
			 System.out.println(mttc);
			 
		PreparedStatement	 ps2=conn.prepareStatement("UPDATE `bon_reception` SET `montantht`=?,`tva`=?,`montantttc`=? WHERE `id`='"+ id +"'");
			 ps2.setFloat(1,montant);
			 ps2.setFloat(2, tvaa);
			 ps2.setFloat(3, mttc);
			 ps2.executeUpdate();
			 } catch(Exception e) {
				 System.out.println(e.getMessage());
			 }
		 }
		
	}catch(SQLException e2){
		System.out.println(e2);
	}
	}
	public void verifier(Product produit,String id,int stock) {
	    try
	    {
	    	conn=DBconnect.getConn();
	      
	    	PreparedStatement  ps = conn.prepareStatement("SELECT * FROM `product` WHERE `name` ='"+ id +"'");
	        System.out.println(ps);  
	        ResultSet rs = ps.executeQuery();
	        if (rs.next())
	        {
	        	 try {
	        		 
	 	  	    int nvstock=Integer.parseInt(ps.getResultSet().getString("quantite").toString())+stock;
	 	  		ps=conn.prepareStatement("UPDATE `product` SET `quantite`='"+nvstock +"'WHERE `name`='"+ id +"'");
	 	  		System.out.println(ps);
	 			ps.executeUpdate();
	 	            if(ps.executeUpdate()>0){
	 	                System.out.println("modifier avaec success");
	 	            }
	 	        } catch (SQLException ex) {
	 	            System.out.println(ex.getMessage());
	 	            
	 	            
	 	        } 
	           
	        }

	    } 

	    catch (SQLException ex) 
	    {
	        while (ex != null) 
	        {
	            ex.printStackTrace();
	            ex = ex.getNextException();
	        }
		}
	}
}
