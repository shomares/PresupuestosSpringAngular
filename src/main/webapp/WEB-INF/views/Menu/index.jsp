<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<title>Producto::Presupuesto</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="theme-color" content="#1e88e5">
<meta name="mobile-web-app-capable" content="yes">

<!-- Estilos -->
<link href="<c:url value="/resources/css/alertify.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/alertify.rtl.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/materialize/css/materialize.css"/>"
	rel="stylesheet">

<link rel="shortcut icon" sizes="196x196"
	href="<c:url value="/resources/img/ic_account_balance_black_24dp_2x.png" />">
<!-- Librerias Script-->
<script src="<c:url value="/resources/js/libs/jquery/jquery.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery/Extentions.js" />"></script>
<script src="<c:url value="/resources/js/libs/Eventos.js" />"></script>
<script src="<c:url value="/resources/js/libs/angular.js/angular.js" />"></script>
<script src="<c:url value="/resources/js/dao/DaoGeneral.js" />"></script>

<script
	src="<c:url value="/resources/js/libs/alertify.js/alertify.min.js" />"></script>

</head>
<body ng-app="presupuestos" ng-controller="ctrlEditarActividad">
	<nav>
		<div class="nav-wrapper blue darken-1 blue darken-1">
			<a href="#!" class="brand-logo"> AccountLink JS</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons"> <img
					src="<c:url value="/resources/img/ic_view_headline_white_36dp_1x.png" />">
			</i></a>

			<ul id="dropdown1" class="dropdown-content">
				<li><a href="<c:url value="/MateriaPrima" />">Materia Prima</a></li>
				<li><a href="<c:url value="/Producto" />">Producto</a></li>
				<li><a href="<c:url value="/UsoMateriaPrima" />">Uso de
						Materia Prima</a></li>
				<li class="divider"></li>
				<li><a href="<c:url value="/Actividad" />">Actividades</a></li>
				<li><a href="<c:url value="/CostoActividad" />">Costo de
						Actividades Por Producto</a></li>
			</ul>


			<ul id="dropdown2" class="dropdown-content">
				<li><a href="<c:url value="/BalanceGeneral" />">Balance
						General</a></li>
				<li><a href="<c:url value="/Configuracion" />">Configuracion</a></li>
			</ul>


			<ul class="right hide-on-med-and-down">
				<li><a class="dropdown-button" href="#!"
					data-activates="dropdown2">Configuracion</a></li>
				<li><a class="dropdown-button" href="j_spring_security_logout">Salir</a></li>
				<li><a class="dropdown-button" href="#!"
					data-activates="dropdown1">Catalogos</a></li>

				<li class="material-icons"><a href="<c:url value="/Menu" />"><img
						src="<c:url value="/resources/img/ic_settings_backup_restore_white_36dp_1x.png" />"></a></li>
			</ul>


		</div>

		<ul class="side-nav" id="mobile-demo">
			<li><a href="<c:url value="/BalanceGeneral" />">Balance
					General</a></li>
			<li><a href="<c:url value="/Configuracion" />">Configuracion</a></li>
			<li class="divider"></li>

			<li><a href="<c:url value="/MateriaPrima" />">Materia Prima</a></li>
			<li><a href="<c:url value="/Producto" />">Producto</a></li>
			<li><a href="<c:url value="/UsoMateriaPrima" />">Uso de
					Materia Prima</a></li>
			<li class="divider"></li>

			<li><a href="<c:url value="/Actividad" />">Actividades</a></li>
			<li><a href="<c:url value="/CostoActividad" />">Costo de
					Actividades Por Producto</a></li>
			<li><a href="../j_spring_security_logout">Salir</a></li>




		</ul>
	</nav>

	<div class="container">
		<div class="container">
			<br> <br>
			<h1 class="header center ">Presupuestos</h1>
			<div class="row center">
				<h5 class="header col s12 light">Una solucion</h5>
			</div>
			<div class="row center">
				<a href="<c:url value="/Presupuesto" />" id="download-button"
					class="btn-large waves-effect waves-light ">Calcular</a>
			</div>
			<br> <br>

		</div>

	</div>
	<script
		src="<c:url value="/resources/js/controladores/presupuesto/ctrlActividad.js" />"></script>
	<script
		src="<c:url value="/resources/materialize/js/materialize.js" />"></script>

	<script src="http://materializecss.com/js/init.js">
		
	</script>
	<script>
		$(".button-collapse").sideNav();
	</script>
</body>
</html>
