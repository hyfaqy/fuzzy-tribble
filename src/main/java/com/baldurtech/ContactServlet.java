package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactServlet extends HttpServlet{
	public	void doGet(HttpServletRequest request, HttpServletResponse response)
						throws IOException,ServletException {
		response.getWriter().println("Get contact by id: " + request.getParameter("contactId"));
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception ex){
		
		}
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
			response.getWriter().println(connection);
			connection.close();
		}catch(SQLException sqle){
			response.getWriter().println("Cannot connect to DB.");
			response.getWriter().println(sqle.getMessage());
			sqle.printStackTrace();
		}
	}											
}