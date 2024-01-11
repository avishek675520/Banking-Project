package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customer_Dao;
import Dto.Customer;
@WebServlet("/customersignup")
public class Coustomersignup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String mob=req.getParameter("mob");
		long mobile=Long.parseLong(mob);
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
//		String male=req.getParameter("male");
//		String female=req.getParameter("female");
		String Gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		
		System.out.println("name:-"+name);
		System.out.println("mobile:-"+mobile);
		System.out.println("pwd:-"+pwd);
		System.out.println("email:-"+email);
//		System.out.println("male:-"+male);
//		System.out.println("female:-"+female);
		System.out.println("gender:-"+Gender);
		System.out.println(dob);
		
		
//		resp.getWriter().print("<h1>Thank you</h1>");
//		resp.getWriter().print("<h1>"+name+"</h1>"
//				+ "<h1>"+pwd+"</h1>"
//				+ "<h1>"+email+"</h1>"
//				+ "<h1>"+Gender+"</h1>"
//				+"<h1>"+dob+"</h1>");
//		resp.getWriter().print("<h1>"+mobile+"</h1>");
//		resp.getWriter().print("<h1>"+pwd+"</h1>");
//		resp.getWriter().print("<h1>"+email+"</h1>");
//		resp.getWriter().print("<h1>"+Gender+"</h1>");
		
		Date date=Date.valueOf(dob);
		Period period=Period.between(date.toLocalDate(), LocalDate.now());
		int age=period.getYears();
		Customer customer=new Customer();
		Customer_Dao customer_Dao=new Customer_Dao();
		if(age>18)
		{
			if(customer_Dao.check1(email).isEmpty()&& customer_Dao.check2(mobile).isEmpty())
			{
				customer.setName(name);
				customer.setPwd(pwd);
				customer.setEmail(email);
				customer.setGrnder(Gender);
				customer.setMob(mobile);
				customer.setDate(date);
				customer_Dao.save(customer);
				resp.getWriter().print("<h1>you are eligeble</h1>");
				
				List<Customer> list=customer_Dao.check1(email);
				Customer exsitCustomer=list.get(0);
				if(exsitCustomer.getGrnder().equals("female"))
				{
					resp.getWriter().print("wwllcome madam"+"your id is "+exsitCustomer.getCid());
				}
				else
				{
					resp.getWriter().print("wwllcome sir"+"your id is "+exsitCustomer.getCid());
				}
				resp.getWriter().print("<h1>Account create sucessfully</h1>");
				req.getRequestDispatcher("Customerlogin.html").include(req, resp);
			}
			else {
				resp.getWriter().print("the acount is email_id"+email+"the phone number "+mobile+"is presents");
			}
		}
		else
		{
			resp.getWriter().print("<h1>you are not eligeble</h1>");
		}
	}

}
