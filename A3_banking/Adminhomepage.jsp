<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
*{
background-image: url("bankimg.jpg");
background-repeat: no-repeat;
background-size: cover;
color: white;
}
table {
	margin-left: 650px;
	margin-top: 200px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Bank_account> list =(List<Bank_account>)request.getSession().getAttribute("list");%>
<table border="1">
<tr>
<th>Account_number</th>
<th>Account_type</th>
<th>Customer_name</th>
<th>Coustomer_id</th>
<th>Coustomer_status</th>
<th>Change_status</th>
</tr>
<%for(Bank_account bank_account:list){ %>
<tr>
<th><%=bank_account.getAcc_no()%></th>
<th><%=bank_account.getAccount_type() %></th>
<th><%=bank_account.getCustomer().getName() %></th>
<th><%=bank_account.getCustomer().getCid() %></th>
<th><%=bank_account.isStatus() %></th>
<th><a href="changestatus?acno=<%=bank_account.getAcc_no() %>"><button>change_status</button></a></th>
</tr>


<% }%>
</table>

</body>
</html>