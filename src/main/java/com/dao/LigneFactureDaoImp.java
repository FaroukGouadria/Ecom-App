package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.BD.DBconnect;
import com.entity.Ligne_Facture_Client;
import com.entity.Ligne_bon_reception;
import com.entity.Product;



public class LigneFactureDaoImp implements LigneFactureDAO {
		private Connection conn;
	public LigneFactureDaoImp(Connection conn) {
			super();
			this.conn = conn;
		}

	public boolean ajouterLignefacture(Ligne_Facture_Client lfc) {
		boolean f=false;
		try {
				String sql="INSERT INTO `lignefactureclient`(`codeligne`, `codefacture`, `name`, `price`, `quantite`, `montantht`, `tva`) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, lfc.getCodeligne());
					ps.setInt(2, lfc.getCodefacture());
					ps.setString(3, lfc.getName());
					ps.setInt(4, lfc.getPrice());
					ps.setInt(5, lfc.getQuantite());
					ps.setFloat(6, lfc.getPrixht());
					ps.setFloat(7,lfc.getTva());
				int i=ps.executeUpdate();
					
				if(i==1) {
					f=true;
				}
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return f;
	}

	public List<Ligne_Facture_Client> getAllligne() {
		// TODO Auto-generated method stub
		return null;
	}

	public Ligne_Facture_Client getlignebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateligne(Ligne_Facture_Client lfc) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteligne(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void remplirfacture(Ligne_Facture_Client lb,int id)  {
		conn=DBconnect.getConn();
	try {
	PreparedStatement ps=conn.prepareStatement("SELECT SUM(`tva`) as totaltva,SUM(`montantht`) as montant FROM `lignefactureclient` WHERE `codeligne`='"+ id +"'");
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
		 
	PreparedStatement ps2=conn.prepareStatement("UPDATE `facture` SET `montht`=?,`tva`=?,`montantttc`=? WHERE `id`='"+ id +"'");
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
public void verifier(String id,int stock) {
    try
    {
    	conn=DBconnect.getConn();
      
    	PreparedStatement  ps = conn.prepareStatement("SELECT * FROM `product` WHERE `name` ='"+ id +"'");
        System.out.println(ps);  
        ResultSet rs = ps.executeQuery();
        if (rs.next())
        {
        	 try {
        		 
 	  	    int nvstock=Integer.parseInt(ps.getResultSet().getString("quantite").toString())-stock;
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
