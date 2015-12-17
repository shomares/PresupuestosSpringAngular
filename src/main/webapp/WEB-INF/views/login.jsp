<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://d2d1dxiu3v1f2i.cloudfront.net/3b95e79/css/index.css"
	media="screen" rel="stylesheet">


<script async="" defer=""
	src="https://d2d1dxiu3v1f2i.cloudfront.net/3b95e79/js/index.js"
	sp-bootstrap="{&quot;country&quot;:&quot;MX&quot;,&quot;locales&quot;:[&quot;es_ES&quot;,&quot;es&quot;]}"></script>
</head>
<body>

	<c:url var="urlAutentificar" value="/autentificar"/>

	<div class="container-fluid login ng-scope">
		<div sp-header="" class="ng-scope">
			<div class="head ">
				<h1>AccountJS</h1>
			</div>
		</div>
		<div class="content">
			<form class="col s12"  action="${urlAutentificar}" method="post">
				<input  type="text"
					class="form-control input-with-feedback ng-pristine ng-invalid ng-invalid-required"
					name="email"  id="login-password" placeholder="Usuario"
					required="" autocomplete="off" ng-trim="false">
					 <br> 
					 <input ng-model="form.password" type="password"
					class="form-control input-with-feedback ng-pristine ng-invalid ng-invalid-required"
					name="password" id="login-password" placeholder="Contraseña"
					required="" autocomplete="off" ng-trim="false"> <br>
				<button class="btn btn-sm btn-block btn-green ng-binding">Iniciar
					Sesión</button>
				<br> </br>

			</form>
		</div>
	</div>

	
	<c:if test="${errorLogin}">
	    El usuario o password son incorrectos
	</c:if>


	<!-- Librerias Script-->
	<script src="resources/js/libs/jquery/jquery.js" /></script>
	<script src="resources/js/libs/alertify.js/alertify.min.js" /></script>





</body>
</html>