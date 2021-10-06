package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BD.DBconnect;
import com.dao.FournisseurDaoImpl;
import com.entity.Fournisseur;
import com.google.gson.Gson;
import java.util.*;

/**
 * Servlet implementation class carts
 */
@WebServlet("/chart")
public class charts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public charts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FournisseurDaoImpl dao=new FournisseurDaoImpl(DBconnect.getConn());
		Gson gson= new Gson();
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.println(gson.toJson(dao.getAllfournisseur()));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
