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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
			
			List contacts = new ArrayList();
			
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
					
					Map contact = new HashMap();
					
					contact.put("Name",name);
					contact.put("Mobile",mobile);
					contact.put("Vpmn",vpmn);
					contact.put("Email",email);
					contact.put("Homeaddress",homeaddress);
					contact.put("Officeaddress",officeaddress);
					contact.put("Memo",memo);
					contact.put("Groups",groups);
					contact.put("Job",job);
					contact.put("JobLevel",joblevel);
					
					contacts.add(contact);
					
					response.getWriter().println("Name:" + contact.get("Name"));
					response.getWriter().println("Mobile:" + contact.get("Mobile"));
					response.getWriter().println("Vpmn:" + contact.get("Vpmn"));
					response.getWriter().println("Email:" + contact.get("Email"));
					response.getWriter().println("Homeaddress:" + contact.get("Homeaddress"));
					response.getWriter().println("Officeaddress:" + contact.get("Officeaddress"));
					response.getWriter().println("Memo:" + contact.get("Memo"));
					response.getWriter().println("Groups:" + contact.get("Groups"));
					response.getWriter().println("Job:" + contact.get("Job"));
					response.getWriter().println("JobLevel:" + contact.get("JobLevel"));
					
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
					List contacts = new ArrayList();
					
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
					
					Map contact = new HashMap();
					
					contact.put("Name",name);
					contact.put("Mobile",mobile);
					contact.put("Vpmn",vpmn);
					contact.put("Email",email);
					contact.put("Homeaddress",homeaddress);
					contact.put("Officeaddress",officeaddress);
					contact.put("Memo",memo);
					contact.put("Groups",groups);
					contact.put("Job",job);
					contact.put("JobLevel",joblevel);
					
					contacts.add(contact);
					
					response.getWriter().println("Name:" + contact.get("Name"));
					response.getWriter().println("Mobile:" + contact.get("Mobile"));
					response.getWriter().println("Vpmn:" + contact.get("Vpmn"));
					response.getWriter().println("Email:" + contact.get("Email"));
					response.getWriter().println("Homeaddress:" + contact.get("Homeaddress"));
					response.getWriter().println("Officeaddress:" + contact.get("Officeaddress"));
					response.getWriter().println("Memo:" + contact.get("Memo"));
					response.getWriter().println("Groups:" + contact.get("Groups"));
					response.getWriter().println("Job:" + contact.get("Job"));
					response.getWriter().println("JobLevel:" + contact.get("JobLevel"));
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