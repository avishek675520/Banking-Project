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
@WebServlet("/withdraw")
public class WithDraw extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
			String amt=req.getParameter("amnt");
		
			double amount =Double.parseDouble(amt);
			long acno=(long) req.getSession().getAttribute("ac_number");
			BankDao bankDao=new BankDao();
			Bank_account bank_account=bankDao.find(acno);
			if(bank_account.getAmount()<amount)
			{
				resp.getWriter().print("<h1>Insufficient balance :"+bank_account.getAmount()+"</h1>");
				req.getRequestDispatcher("Accounthome.html").include(req, resp);
			}
			else
			{
				if(amount>bank_account.getAcc_limit())
				{
					resp.getWriter().print("<h1>your execeding your account limit ypur actual limit is:"+bank_account.getAcc_limit()+"</h1>");
					req.getRequestDispatcher("Accounthome.html").include(req, resp);
				}
				else
				{
					bank_account.setAmount(bank_account.getAmount()-amount);
					
					
					Bank_trransation bank_trransation=new Bank_trransation();
					bank_trransation.setDeposit(0);
					bank_trransation.setWithdraw(amount);
					bank_trransation.setBalance(bank_account.getAmount());
					bank_trransation.setDate_time(LocalDateTime.now());
					
					List<Bank_trransation>list2=bank_account.getList();
					list2.add(bank_trransation);
					bank_account.setList(list2);
					bankDao.update_the_account_status(bank_account);
					resp.getWriter().print("<h1>Amount withdraw successfull</h1>");
					req.getRequestDispatcher("Accounthome.html").include(req, resp);
					
				}
			}
			

	}

}
