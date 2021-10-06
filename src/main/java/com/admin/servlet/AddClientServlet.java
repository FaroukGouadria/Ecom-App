package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.ClientDaoImpl;
import com.entity.Client;

@WebServlet("/add_client")
@MultipartConfig
public class AddClientServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("fname");
			String code=req.getParameter("fcode");
			String matricule=req.getParameter("fmatricule");
			String adresse=req.getParameter("faddresse");
			int phone=Integer.parseInt(req.getParameter("fphone"));
			String email=req.getParameter("femail");
			
				Client c=new Client(code, name, matricule, adresse, phone, email);
				ClientDaoImpl dao=new ClientDaoImpl(DBconnect.getConn());
				boolean fa=dao.ajouterClient(c);
				HttpSession session=req.getSession();
				
				if(fa) {
					
					session.setAttribute("SuccMsg", "Fournisseur Add Sucessfully");
					resp.sendRedirect("admin/all_client.jsp");
				}else {
					session.setAttribute("failedMsg", "something wrong in server...!");
					resp.sendRedirect("admin/add_client.jsp");
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}

