package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.ProductDaoImpl;
import com.entity.Product;

@WebServlet("/edit_prod")
public class EditProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 
			try {
				int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("fname");
				int price=Integer.parseInt(req.getParameter("fprice"));
				int quantite=Integer.parseInt(req.getParameter("fquantite"));
				String category=req.getParameter("fcategory");
				
				Product p=new Product();
				p.setId(id);
				p.setName(name);
				p.setPrice(price);
				p.setQuantite(quantite);
				p.setCategory(category);
				
				ProductDaoImpl dao=new ProductDaoImpl(DBconnect.getConn());
				boolean f=dao.updateproduct(p);
				HttpSession session=req.getSession();
				
				if(f) {
					
					session.setAttribute("SuccMsg","Product udpate succesfully");
					resp.sendRedirect("admin/all_product.jsp");
				}else{
					
					session.setAttribute("failedMsg","Something wrong on server");
					resp.sendRedirect("admin/all_product.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}
	

}
