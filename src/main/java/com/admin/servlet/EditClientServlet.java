package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.ClientDaoImpl;
import com.entity.Client;


@WebServlet("/edit_cl")
public class EditClientServlet extends HttpServlet{
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
		Client c=new Client();
		c.setId(id);
		c.setCode(code);
		c.setName(name);
		c.setMatricule(matricule);
		c.setAdresse(adresse);
		c.setPhone(phone);
		c.setEmail_fc(email);
		
		ClientDaoImpl dao=new ClientDaoImpl(DBconnect.getConn());
		boolean fa=dao.updateClient(c);
		HttpSession session=req.getSession();
		
		if(fa) {
			
			session.setAttribute("SuccMsg", "Fournisseur Update Sucessfully");
			resp.sendRedirect("admin/all_client.jsp");
		}else {
			session.setAttribute("failedMsg", "something wrong in server...!");
			resp.sendRedirect("admin/all_client.jsp");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}

	}
}
