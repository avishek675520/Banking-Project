package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/setacctiveaccount")
public class set_active_account extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String acc_no=req.getParameter("acno");
		long ac_number=Long.parseLong(acc_no);
		req.getSession().setAttribute("ac_number", ac_number);//here we are going to set the active account by using 
		req.getRequestDispatcher("Accounthome.html").include(req, resp);
	}

}
