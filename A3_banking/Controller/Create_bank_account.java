package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.Customer_Dao;
import Dto.Bank_account;
import Dto.Customer;
@WebServlet("/createbankaccount")
public class Create_bank_account extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String account_type=req.getParameter("accounttype");
		Customer customer =(Customer) req.getSession().getAttribute("customer");
		List<Bank_account> list =customer.getBankacconts();
		boolean flag=true;
		
		for(Bank_account bank_account:list)
		{
			if(bank_account.getAccount_type().equals(account_type))
			{
				flag=false;
				break;
			}
		}
		if(flag==true)
		{
			Bank_account bank_account=new Bank_account();
			bank_account.setAccount_type(account_type);
			
			if(bank_account.getAccount_type().equals("savings"))
			{
				bank_account.setAcc_limit(10000);
			}
			else
			bank_account.setAcc_limit(15000);
			
			bank_account.setCustomer(customer);
			
			BankDao bankDao=new BankDao();
			bankDao.save_Account(bank_account);
			
			List<Bank_account>list2=list;
			list2.add(bank_account);
			customer.setBankacconts(list2);
			
			Customer_Dao customer_Dao=new Customer_Dao();
			customer_Dao.update(customer);
			resp.getWriter().print("<h1>your account has created</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1>your account type is already exist for same coustomer</h1>");
		}
		
	}

}
