<%@page import="dao.ProdutoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco de Dados</title>
</head>
<body>
	<h1>Produtos Cadastrados</h1>
	<hr>
	
	<%List<Produto> produtos = new ArrayList<Produto>();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	
	produtos = produtoDAO.listAll();
	
	for(Produto p : produtos){
	%>
	<h2><%=p.getId() + " - " + p.getNome() + " - " + p.getDescricao() + " [" + p.getPreco() + "]"%></h2>
	
	<%} %>
	
</body>
</html>