package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ContactServlet extends HttpServlet{
	public	void doGet(HttpServletRequest request, HttpServletResponse response)
						throws IOException,ServletException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception ex){
		
		}
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from contact where id =" + request.getParameter("contactId"));
			if(resultset.next()){
			response.getWriter().println("name:" + resultset.getString("name"));
			response.getWriter().println("mobile:" + resultset.getString("mobile"));
			response.getWriter().println("vpmn:" + resultset.getString("vpmn"));
			response.getWriter().println("email:" + resultset.getString("email"));
			response.getWriter().println("homeaddress:" + resultset.getString("home_address"));
			response.getWriter().println("officeaddress:" + resultset.getString("office_address"));
			response.getWriter().println("memo:" + resultset.getString("memo"));
			response.getWriter().println("groups:" + resultset.getString("groups"));
			response.getWriter().println("job:" + resultset.getString("job"));
			response.getWriter().println("joblevel:" + resultset.getInt("job_level"));
			}else{
				response.getWriter().println("contact not found!");
			}
		}catch(SQLException sqle){
			response.getWriter().println("Cannot connect to DB.");
			response.getWriter().println(sqle.getMessage());
			sqle.printStackTrace();
		}
		if(connection != null){
			try{
			connection.close();
			}catch (Exception ex){
		
		}
		}
		if(statement != null){
			try{
			statement.close();
		}catch (Exception ex){
		
		}
		}
		if(resultset != null){
			try{
			resultset.close();
		}catch (Exception ex){
		
		}
		}
	}											
}