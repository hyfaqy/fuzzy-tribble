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
		
		String name = null;
		String mobile = null;
		String vpmn = null;
		String email = null;
		String homeaddress = null;
		String officeaddress = null;
		String memo = null;
		String groups = null;
		String job = null;
		Integer joblevel = null;
	
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception ex){
		
		}			
		if(request.getParameter("contactId") == null){
			try{
				connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
				statement = connection.createStatement();
				resultset = statement.executeQuery("select * from contact" );
				
				while(resultset.next()){
				
					name = resultset.getString("name");
					mobile = resultset.getString("mobile");
					vpmn = resultset.getString("vpmn");
					email = resultset.getString("email");
					homeaddress = resultset.getString("home_address");
					officeaddress = resultset.getString("office_address");
					memo = resultset.getString("memo");
					groups = resultset.getString("groups");
					job = resultset.getString("job");
					joblevel = resultset.getInt("job_level");
					
					response.getWriter().println("Name:" + name);
					response.getWriter().println("Mobile:" + mobile);
					response.getWriter().println("Vpmn:" + vpmn);
					response.getWriter().println("Email:" + email);
					response.getWriter().println("Homeaddress:" + homeaddress);
					response.getWriter().println("Officeaddress:" + officeaddress);
					response.getWriter().println("Memo:" + memo);
					response.getWriter().println("Groups:" + groups);
					response.getWriter().println("Job:" + job);
					response.getWriter().println("JobLevel:" + joblevel);
				}
			}catch(SQLException sqle){
					response.getWriter().println("Cannot connect to DB.");
					response.getWriter().println(sqle.getMessage());
					sqle.printStackTrace();
			}
		}
		else{
			try{
				connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
				statement = connection.createStatement();
				resultset = statement.executeQuery("select * from contact where id =" + request.getParameter("contactId"));
				
				if(resultset.next()){
					name = resultset.getString("name");
					mobile = resultset.getString("mobile");
					vpmn = resultset.getString("vpmn");
					email = resultset.getString("email");
					homeaddress = resultset.getString("home_address");
					officeaddress = resultset.getString("office_address");
					memo = resultset.getString("memo");
					groups = resultset.getString("groups");
					job = resultset.getString("job");
					joblevel = resultset.getInt("job_level");
					response.getWriter().println("Name:" + name);
					response.getWriter().println("Mobile:" + mobile);
					response.getWriter().println("Vpmn:" + vpmn);
					response.getWriter().println("Email:" + email);
					response.getWriter().println("Homeaddress:" + homeaddress);
					response.getWriter().println("Officeaddress:" + officeaddress);
					response.getWriter().println("Memo:" + memo);
					response.getWriter().println("Groups:" + groups);
					response.getWriter().println("Job:" + job);
					response.getWriter().println("JobLevel:" + joblevel);
				}else{
					response.getWriter().println("contact not found!");
				}
			}catch(SQLException sqle){
				response.getWriter().println("Cannot connect to DB.");
				response.getWriter().println(sqle.getMessage());
				sqle.printStackTrace();
			}
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