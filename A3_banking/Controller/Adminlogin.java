package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;
@WebServlet("/adminlogin")
public class Adminlogin extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 String name=req.getParameter("name");
		 String email=req.getParameter("email");
		 BankDao bankdao=new BankDao();
		 if(email.equals("avi@gmail.com")&&name.equals("admin"))
		 {
			 resp.getWriter().print("<h1>login successfull</h1>");
			 List<Bank_account>list =bankdao.fetchAll();
			 
			 
			 
			 req.getSession().setAttribute("list", list);
			 req.getRequestDispatcher("Adminhomepage.jsp").include(req, resp);
		 }
		 else
			 resp.getWriter().print("<h1>Invalid credentials</h1>");
		
	}

}
