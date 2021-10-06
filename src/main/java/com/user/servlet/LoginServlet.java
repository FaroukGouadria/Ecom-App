package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BD.DBconnect;
import com.dao.UserDaoImpl;
import com.entity.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				
				UserDaoImpl usdao=new UserDaoImpl(DBconnect.getConn());
				HttpSession session=req.getSession();
				
				String email=req.getParameter("lemail");
				String password=req.getParameter("lpassword");
				
				User u=new User();
				u.setEmail(email);
				u.setPassword(password);
					
				if("admin@gmail.com".equals(email) && "admin".equals(password)) {
					User us=new User();
	 				session.setAttribute("userobj", us);
					resp.sendRedirect("admin/home.jsp");
					
				}else
				{
					
					User us=usdao.userlogin(email, password);
					if(us!=null) {
						session.setAttribute("userobj", us);
						resp.sendRedirect("home.jsp");
						
					}else{
						session.setAttribute("faildMsg", "Email or password Invalid ..!");
						resp.sendRedirect("login.jsp");
					}
					resp.sendRedirect("home.jsp");
					
				}
				
			
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}
