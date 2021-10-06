package com.admin.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.FournisseurDaoImpl;
import com.entity.Fournisseur;
@WebServlet("/add_fournisseur")
@MultipartConfig
public class FournisseurAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("fname");
			String code=req.getParameter("fcode");
			String matricule=req.getParameter("fmatricule");
			String adresse=req.getParameter("faddresse");
			int phone=Integer.parseInt(req.getParameter("fphone"));
			String email=req.getParameter("femail");
			
				Fournisseur f=new Fournisseur(code, name, matricule, adresse, phone, email);
				FournisseurDaoImpl dao=new FournisseurDaoImpl(DBconnect.getConn());
				boolean fa=dao.ajouterfournisseur(f);
				HttpSession session=req.getSession();
				
				if(fa) {
					
					session.setAttribute("SuccMsg", "Fournisseur Add Sucessfully");
					resp.sendRedirect("admin/add_fournisseur.jsp");
				}else {
					session.setAttribute("failedMsg", "something wrong in server...!");
					resp.sendRedirect("admin/add_fournisseur.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
