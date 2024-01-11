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
@WebServlet("/changestatus")
public class Change_status extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String ac_no=req.getParameter("acno");
		long acc_no=Long.parseLong(ac_no);
		BankDao bankDao=new BankDao();
		Bank_account bank_account=bankDao.fetch_account_details(acc_no);
		if(bank_account.isStatus())
		{
			bank_account.setStatus(false);
		}
		else
		{
			bank_account.setStatus(true);
		}
		bankDao.update_the_account_status(bank_account);
		resp.getWriter().print("<h1>Status Updated Sucessfully</h1>");
		List<Bank_account>accounts_information=bankDao.fetchAll();
		req.getSession().setAttribute("list", accounts_information);
		req.getRequestDispatcher("Adminhomepage.jsp").include(req, resp);
		
		
		
	}

}
