package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;
import Dto.Bank_trransation;
@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException 
	{
		String amt=req.getParameter("amnt");
		
		double amount =Double.parseDouble(amt);
		long acno=(long) req.getSession().getAttribute("ac_number");
		BankDao bankDao=new BankDao();
		Bank_account bank_account=bankDao.find(acno);
		bank_account.setAmount(bank_account.getAmount()+amount);
		
		Bank_trransation bank_trransation=new Bank_trransation();
		bank_trransation.setDeposit(amount);
		bank_trransation.setWithdraw(0);
		bank_trransation.setBalance(bank_account.getAmount());
		bank_trransation.setDate_time(LocalDateTime.now());
		
		List<Bank_trransation>list=bank_account.getList();
		list.add(bank_trransation);
		bank_account.setList(list);
		bankDao.update_the_account_status(bank_account);
		reps.getWriter().print("<h1>Amount diposit successfull</h1>");
		req.getRequestDispatcher("Accounthome.html").include(req, reps);
		
	
		
	}

}
