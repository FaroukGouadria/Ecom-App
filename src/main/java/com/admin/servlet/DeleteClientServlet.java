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
@WebServlet("/deletc")
public class DeleteClientServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			ClientDaoImpl dao=new ClientDaoImpl(DBconnect.getConn());
			boolean f=dao.deleteClient(id);
			HttpSession session=req.getSession();
			
			if(f) {
				
				session.setAttribute("SuccMsg","Product deleted succesfully");
				resp.sendRedirect("admin/all_client.jsp");
			}else{
				
				session.setAttribute("failedMsg","Something wrong on server");
				resp.sendRedirect("admin/all_client.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
