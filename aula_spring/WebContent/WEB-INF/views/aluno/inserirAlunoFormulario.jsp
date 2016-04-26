<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Aluno</title>
</head>
<body>
	<form action="inserirAluno" method="post">
		Nome: <input type="text" name="nome"/> <!-- name deve ser igual ao nome do atributo da classe aluno -->
		<br/>
		IRA: <input type="text" name="ira" /> <!-- name deve ser igual ao nome do atributo da classe aluno -->
		<br/>
		<input type="submit" value="Inserir"/>
	</form>
</body>
</html>