package com.dao;

import java.sql.Connection;

import com.BD.DBconnect;
import com.entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
		
	private Connection conn;
	
		public ProductDaoImpl(Connection conn) {
		super();
		this.conn=conn;
	}

		
	
	public boolean ajouterproduct(Product p) {
				boolean f=false;
			try {
					String sql="INSERT INTO `product`( `name`, `price`, `quantite`, `category`, `photos`, `user_email`, `fournisseur`) VALUES (?,?,?,?,?,?,?)";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, p.getName());
						ps.setInt(2, p.getPrice());
						ps.setInt(3, p.getQuantite());
						ps.setString(4, p.getCategory());
						ps.setString(5, p.getPhoto());
						ps.setString(6, p.getEmail());
						ps.setString(7, p.getFornisseur());
					int i=ps.executeUpdate();
					
					if(i==1) {
						f=true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return f;
	}



	public List<Product> getAllproducts() {
		List<Product> l=new ArrayList<Product>();
		Product p=null;
		try {
			String sql="SELECT * FROM `product`";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuantite(rs.getInt(4));
				p.setCategory(rs.getString(5));
				p.setPhoto(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setFornisseur(rs.getString(8));
				l.add(p);
			}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return l;
	}



	public Product getBookbyId(int id) {
		Product p=null;
		
		try {
			String sql="select * from product where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setQuantite(rs.getInt(4));
				p.setCategory(rs.getString(5));
				p.setPhoto(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setFornisseur(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return p;
	}



	public boolean updateproduct(Product p) {
		boolean f=false;
		try {
			String sql="UPDATE `product` SET `name`=?,`price`=?,`quantite`=?,`category`=? WHERE id=?";   
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getCategory());
			ps.setInt(5, p.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}



	public boolean deleteprod(int id) {
		boolean f=false;
		try {
			String sql="delete from product where id=?";
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
