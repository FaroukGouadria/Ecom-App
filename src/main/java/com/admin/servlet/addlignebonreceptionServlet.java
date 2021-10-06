package com.admin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.LignebonServletDaoImpl;
import com.dao.ProductDaoImpl;
import com.entity.Ligne_bon_reception;
import com.entity.Product;

/**
 * Servlet implementation class addlignebonreceptionServlet
 */
@WebServlet("/ligne_bon_reception")
@MultipartConfig
public class addlignebonreceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addlignebonreceptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String codeligne=req.getParameter("fcodeligne");
			int codebon=Integer.parseInt(req.getParameter("fcodebon"));
			String name=req.getParameter("fname");
			int price=Integer.parseInt(req.getParameter("fprice"));
			int quantite=Integer.parseInt(req.getParameter("fquantite"));
			String category=req.getParameter("fcategory");
			Float tva=Float.parseFloat(req.getParameter("ftva"));
			Float prixht=(float) (price*quantite);
			System.out.println(codebon);
			System.out.println(tva);	
			System.out.println(prixht);	
			Product p=new Product(name, price, quantite, category,tva);
			LignebonServletDaoImpl dao=new LignebonServletDaoImpl(DBconnect.getConn());
			Ligne_bon_reception lbc=new Ligne_bon_reception(codeligne, codebon, p,prixht);
			
			int id=p.getId();
			System.out.println("id="+name);
			ProductDaoImpl dao1=new ProductDaoImpl(DBconnect.getConn());
			dao1.ajouterproduct(p);
			
			boolean f=dao.ajouterbon(lbc);
			 HttpSession session=req.getSession();
			 dao.remplircodebon(lbc, codebon);
			 if(f) {
				 System.out.println("1");
				 	
				 	 System.out.println("2");
					session.setAttribute("SuccMsg", "bon Add Sucessfully");
					resp.sendRedirect("admin/allbon.jsp");
				}else {
					session.setAttribute("failedMsg", "something wrong in server...!");
					resp.sendRedirect("admin/ligne_bon_reception.jsp");
			
		}
			 System.out.println("test5");
			 System.out.println("id="+name);
			dao.verifier(p,name,quantite);
			
			
			
				
	}


}
