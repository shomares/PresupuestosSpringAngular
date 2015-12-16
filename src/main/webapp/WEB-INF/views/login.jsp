<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>LOGIN</h1>
	<c:url var="urlAutentificar" value="/autentificar"/>
	
	<c:if test="${errorLogin}">
	    El usuario o password son incorrectos
	</c:if>

	<form action="${urlAutentificar}" method="post">
		<div>
			<label>Usuario:</label><input type="text" name="email" />
		</div>
		<div>
			<label>Password:</label><input type="password" name="password" />
		</div>
		<input type="submit" value="Enviar" />
	</form>



</body>
</html>