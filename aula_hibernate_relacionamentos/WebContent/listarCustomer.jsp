<%@page import="br.ufc.Customer"%>
<%@page import="br.ufc.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
	CustomerDAO cDAO = new CustomerDAO();
	for(Customer c : cDAO.listar()){
	%>

	<h2><%=c.getName()%></h2><br/>

	<%}%>

</body>
</html>