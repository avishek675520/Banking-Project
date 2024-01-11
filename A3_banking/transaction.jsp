<%@page import="Dto.Bank_trransation"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% long acno=(long)request.getSession().getAttribute("ac_number");
BankDao bankDao=new BankDao();
Bank_account bank_account=bankDao.fetch_account_details(acno);
List<Bank_trransation> transation_histiry=bank_account.getList();
%>
<table border="1">
<tr>
<th>T_id</th>
<th>deposit</th>
<th>withdraw</th>
<th>date_time</th>
</tr>

<%
for(Bank_trransation bank_trransation: transation_histiry)
{
%>
<tr>
<th><%=bank_trransation.getTid() %></th>
<th><%=bank_trransation.getDeposit() %></th>
<th><%=bank_trransation.getWithdraw()%></th>
<th><%=bank_trransation.getDate_time()%></th>
</tr>
<%}%>
</table>
</body>
</html>