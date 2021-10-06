package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.FournisseurDaoImpl;
import com.entity.Fournisseur;

@WebServlet("/edit_fr")
public class EditFournisseur extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("fname");
		String code=req.getParameter("fcode");
		String matricule=req.getParameter("fmatricule");
		String adresse=req.getParameter("faddresse");
		int phone=Integer.parseInt(req.getParameter("fphone"));
		String email=req.getParameter("femail");
		Fournisseur f=new Fournisseur();
		f.setId(id);
		f.setCode(code);
		f.setName(name);
		f.setMatricule_fiscale_fc(matricule);
		f.setAdresse(adresse);
		f.setPhone(phone);
		f.setEmail_fc(email);
		
		FournisseurDaoImpl dao=new FournisseurDaoImpl(DBconnect.getConn());
		boolean fa=dao.updatefournisseur(f);
		HttpSession session=req.getSession();
		
		if(fa) {
			
			session.setAttribute("SuccMsg", "Fournisseur Update Sucessfully");
			resp.sendRedirect("admin/all_fournisseur.jsp");
		}else {
			session.setAttribute("failedMsg", "something wrong in server...!");
			resp.sendRedirect("admin/all_fournisseur.jsp");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}

	}

}
