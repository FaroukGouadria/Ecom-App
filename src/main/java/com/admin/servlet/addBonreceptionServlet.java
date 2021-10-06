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
import com.dao.BonreceptionDaoImpl;
import com.entity.Bon_reception;

/**
 * Servlet implementation class addBonreceptionServlet
 */
@WebServlet("/bon_reception")
@MultipartConfig
public class addBonreceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBonreceptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code=req.getParameter("fcode");
		String addresse=req.getParameter("faddresse");
		String fournisseur=req.getParameter("ffornisseur");
		String date_bon=req.getParameter("fdatebon");
		String date_recp=req.getParameter("fdaterec");
		Float mtht=Float.parseFloat(req.getParameter("fmtht"));
		Float tva=Float.parseFloat(req.getParameter("ftva"));
		//Float mttc=Float.parseFloat(req.getParameter("fmttc"));
		
		
		Bon_reception bon=new Bon_reception(code, addresse, fournisseur, date_bon, date_recp, mtht, tva, 1);
		BonreceptionDaoImpl pdi=new BonreceptionDaoImpl(DBconnect.getConn());
		boolean f=pdi.ajouterbon(bon);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("SuccMsg", "bon Add Sucessfully");
			resp.sendRedirect("admin/allbon.jsp");
		}else {
			session.setAttribute("failedMsg", "something wrong in server...!");
			resp.sendRedirect("admin/bon_reception.jsp");
		}
	}

}
