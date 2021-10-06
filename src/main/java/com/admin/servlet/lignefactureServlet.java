package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.LigneFactureDaoImp;
import com.entity.Ligne_Facture_Client;

/**
 * Servlet implementation class lignefactureServlet
 */
@WebServlet("/ligne_facture_client")
public class lignefactureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lignefactureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeligne=req.getParameter("fcodeligne");
		int codefacture=Integer.parseInt(req.getParameter("fcodefacture"));
		String name=req.getParameter("fname");
		int price=Integer.parseInt(req.getParameter("fprice"));
		int quantite=Integer.parseInt(req.getParameter("fquantite"));
		Float tva=Float.parseFloat(req.getParameter("ftva"));
		Float prixht=(float) (price*quantite);
		System.out.println(codefacture);
		System.out.println(tva);	
		System.out.println(prixht);	
		Ligne_Facture_Client lf=new Ligne_Facture_Client(codeligne, codefacture, name, price, quantite, tva, prixht);
		LigneFactureDaoImp dao=new LigneFactureDaoImp(DBconnect.getConn());
		boolean f=dao.ajouterLignefacture(lf);
		 HttpSession session=req.getSession();
		dao.remplirfacture(lf, codefacture);
		 if(f) {
			 System.out.println("1");
			 	
			 	 System.out.println("2");
				session.setAttribute("SuccMsg", "ligne facture Add Sucessfully");
				resp.sendRedirect("admin/allfacture.jsp");
			}else {
				session.setAttribute("failedMsg", "something wrong in server...!");
				resp.sendRedirect("admin/ligne_facture_client.jsp");
		
	}
		 System.out.println("test5");
		 System.out.println("id="+name);
		 dao.verifier(name,quantite);
	}
	

}
