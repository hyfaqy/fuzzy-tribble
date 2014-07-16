package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class ContactServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					  HttpServletResponse resp)
					  throws IOException,ServletException{
		resp.getWriter().println("OK");			  
	
	}
	public void doPost(HttpServletRequest req,
					   HttpServletResponse resp)
					   throws IOException,ServletException{
		String username = req.getParameter("username");	
		String password = req.getParameter("password");
		
		resp.getWriter().println("username:" + username);
		resp.getWriter().println("password:" + password);
	}
}