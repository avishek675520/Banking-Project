<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Account Type</title>
<style type="text/css">
*{
box-sizing: border-box;
margin: 0px;
padding: 0px;
font-size: 40px;
color: white;
}
div {
	margin-left: 400px;
	margin-top: 150px;
	box-shadow: 10px 10px 4px black;
	height: 500px;
	width: 800px;
	background-image: url("bankimg.jpg");
}
button {
	height: 90px;
	width: 190px;
	border-radius: 50px;
	margin-left: 100px;
	color: red;
}
input {
	margin-left: 00px;
	height: 30px;
	border: px solid black;
}
label {
	border: 20px solid black;
	color: red;
	border-radius: 50px;
	
}
</style>
</head>
<body>
<div>
<h1>Welcome _to_account_creation_page</h1><br>
<% Customer customer =(Customer) request.getSession().getAttribute("customer");%>
<h1>hello:dear <%= customer.getName()%></h1><br>
<form action="createbankaccount">
<input type="radio" name="accounttype" value="savings" id="a"><label for="a">savings</label><br><br>
<input type="radio" name="accounttype" value="current" id="b" ><label for="b">Current</label> <br><br>
<button>submit</button>
<button type="reset">cancle</button>
</form>
</div>

</body>
</html>