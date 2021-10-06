package com.dao;

import java.sql.Connection;

import com.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements userdao {
		private Connection conn;
		
		
		public UserDaoImpl(Connection conn) {
			super();
			this.conn = conn;
		}
	public boolean userRegister(User us) {
		boolean f= false;
		
		try {
			String sql="INSERT INTO `user`(`name`, `email`, `phone`, `password`) values(?,?,?,?)";
			PreparedStatement ps= conn .prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhone());
			ps.setString(4, us.getPassword());
		
			int i=ps.executeUpdate();
		
			if(i==1) {
				return true;
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		return false;
	}
	public User userlogin (String email, String password) {
		User u=null;
		try {
			String sql="SELECT * FROM `user` WHERE email=? and password=? ";
			PreparedStatement ps= conn .prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setAdress(rs.getString(6));
				u.setCity(rs.getString(7));
				u.setState(rs.getString(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return u;
	}
	

}
