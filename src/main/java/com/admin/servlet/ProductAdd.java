package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.BD.DBconnect;
import com.dao.ProductDaoImpl;
import com.entity.Fournisseur;
import com.entity.Product;
@WebServlet("/add_product")
@MultipartConfig
public class ProductAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				String name=req.getParameter("fname");
				int price=Integer.parseInt(req.getParameter("fprice"));
				int quantite=Integer.parseInt(req.getParameter("fquantite"));
				String category=req.getParameter("fcategory");
				String fournisseur=req.getParameter("ffornisseur");
				Part part=req.getPart("fimg");
				String photo=part.getSubmittedFileName();
					String path=getServletContext().getRealPath("")+"product";
							System.out.println(path);
							
					File file =new File(path);
					part.write(path+File.separator+name);
				
				Product p=new Product(name, price, quantite, category, photo, "admin",fournisseur);
				
				//System.out.println(p);
				//System.out.println(p.getName());
				
				
				ProductDaoImpl pdi=new ProductDaoImpl(DBconnect.getConn());
				boolean f=pdi.ajouterproduct(p);
				HttpSession session=req.getSession();
				if(f) {
					session.setAttribute("SuccMsg", "product Add Sucessfully");
					resp.sendRedirect("admin/add_product.jsp");
				}else {
					session.setAttribute("failedMsg", "something wrong in server...!");
					resp.sendRedirect("admin/add_product.jsp");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
