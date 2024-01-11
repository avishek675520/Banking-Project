package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Customer_Dao;
import Dto.Customer;

@WebServlet("/Customerlogin")
public class Customerlogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid=req.getParameter("custid");
		
		int customerid=Integer.parseInt(cid);
		String password=req.getParameter("pwd");
		Customer_Dao customer_Dao=new Customer_Dao();
		Customer customer=customer_Dao.login(customerid);
		if(customer==null)
		{
			resp.getWriter().print("<h1>Invalid cust id</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}
		else
		{
			if(customer.getPwd().equals(password))
			{
				resp.getWriter().print("<h1><marquee behavior=\"slide\"><h1>..........login sucessful........</h1></marquee></h1>");
				
				req.getSession().setAttribute("customer", customer);// it is use to store to set the information of customer for future use
				req.getRequestDispatcher("Coustomerhome.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("home.html").include(req, resp);
			}
		}
	}

}
