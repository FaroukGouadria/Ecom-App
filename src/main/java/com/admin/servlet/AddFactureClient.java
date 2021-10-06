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
import com.dao.FactureDAOImpl;
import com.entity.Facture;
@WebServlet("/add_facture")
@MultipartConfig
public class AddFactureClient extends HttpServlet {

	
	
	public AddFactureClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String code=req.getParameter("fcode");
		String addresse=req.getParameter("faddresse");
		String client=req.getParameter("fclient");
		String date=req.getParameter("fdate");
		Float mtht=Float.parseFloat(req.getParameter("fmtht"));
		Float tva=Float.parseFloat(req.getParameter("ftva"));
		
		Facture facture =new Facture(code, addresse, client, date, mtht, tva, 0);
		FactureDAOImpl DAO=new FactureDAOImpl(DBconnect.getConn());
		boolean f=DAO.ajouterfacture(facture);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("SuccMsg", "Facture Add Sucessfully");
			resp.sendRedirect("admin/allfacture.jsp");
		}else {
			session.setAttribute("failedMsg", "something wrong in server...!");
			resp.sendRedirect("admin/add_facture.jsp");
		}
	}
	}
		
