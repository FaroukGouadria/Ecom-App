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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String name=req.getParameter("fname");
		String email=req.getParameter("femail");
		String phone=req.getParameter("fphone");
		String password=req.getParameter("fpassword");
		String check=req.getParameter("fcheck");
		
		//System.out.println(name+""+email+""+phone+""+password+""+check);
		
		User u=new User();
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setPassword(password);

		HttpSession session=req.getSession();
		
		//System.out.println(check);
	
		if(check != null) {
			
			UserDaoImpl us=new UserDaoImpl(DBconnect.getConn());
			boolean f=us.userRegister(u);
			if(f) {
				//System.out.println("sucess");
				session.setAttribute("succMsg", "Register Success ...");
				resp.sendRedirect("register.jsp");
			}else {
				//System.out.println("failed");
				session.setAttribute("failedMsg", "Register failed ...");
				resp.sendRedirect("register.jsp");
			}
		}else {
			//System.out.println("matansech tcheck ");
			session.setAttribute("succMsg", "Register failed check your server ...");
			resp.sendRedirect("register.jsp");
		}
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	
	

}
