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

<!-- Estilos -->
<link href="<c:url value="/resources/css/alertify.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/alertify.rtl.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/materialize/css/materialize.css"/>"
	rel="stylesheet">


<!-- Librerias Script-->
<script src="<c:url value="/resources/js/libs/jquery/jquery.js" />"></script>
<script src="<c:url value="/resources/js/libs/Eventos.js" />"></script>
<script src="<c:url value="/resources/js/libs/angular.js/angular.js" />"></script>
<script src="<c:url value="/resources/js/dao/DaoGeneral.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery/Extentions.js" />"></script>

<script
	src="<c:url value="/resources/js/libs/alertify.js/alertify.min.js" />"></script>

</head>
<body ng-app="presupuestos" ng-controller="ctrlNuevoActividad">
	<nav>
		<div class="nav-wrapper blue darken-1">
			<a href="#!" class="brand-logo"> AccountLink JS</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons"> <img
					src="<c:url value="/resources/img/ic_view_headline_white_36dp_1x.png" />">

			</i></a>
			<ul class="right hide-on-med-and-down">
				<li class="material-icons"><a href="<c:url value="/Menu" />">"<img
						src="<c:url value="/resources/img/ic_settings_backup_restore_white_36dp_1x.png" />"></a></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><a href="<c:url value="/Producto" />">Regresar</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<header>
			<h3>Actividad</h3>
		</header>


		<form ng-submit="enviar()">
			<p>
				<label>Nombre: </label><br> <input type="text"
					ng-model="objeto.nombre" class="validate" required autofocus>
			</p>
			<p>
				<label>Descripcion: </label><br>
				<textarea ng-model="objeto.descripcion" class="validate" required
					autofocus>
						</textarea>
			</p>
			<p>
				<label>Cargo Indirecto:</label><br> <input type="number"
					step="0.01" ng-model="objeto.cargoIndirecto" class="validate" min="1"
					required autofocus>
			</p>

			<p>
				<label>Vales Almacen:</label><br> <input type="number"
					step="0.01" ng-model="objeto.valesAlmacen" class="validate" min="1"
					required autofocus>
			</p>

			<p>
				<label>Vales Mantenimiento:</label><br> <input type="number"
					step="0.01" ng-model="objeto.valesMantenimiento" class="validate"
					required autofocus min="1">
			</p>

			<input type="submit" value="Enviar" ng-click="enviar"
				class="btn btn-info">

		</form>

	</div>
	<script
		src="<c:url value="/resources/js/controladores/presupuesto/ctrlActividad.js" />"></script>
	<script
		src="<c:url value="/resources/materialize/js/materialize.js" />"></script>
	<script>
		$(".button-collapse").sideNav();
	</script>



</body>


</html>
