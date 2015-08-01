/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

var app = angular.module('presupuestos', []);

app.controller('ctrlNuevoUsoMateriaPrima', function($scope, $location) {

	var id;
	id = $location.search().id;

	$.postJSON("GetIdAll", id, function(salida) {
		if (salida === undefined)
			alert("No se ha podido contactar con el servidor");
		else {
			$scope.objeto = salida;
			$scope.$apply();
		}

	});
	$scope.enviar = function() {
		$.postJSON("inserta", $scope.objeto, function(salida) {
			if (salida.resultado !== "OK")
				alert(salida.resultado);
			else
				window.history.back();
		});

	};

});

app.controller('ctrlEditarUsoMateriaPrima', function($scope) {
	var baseDatos = new DaoGeneral("Producto");

	$scope.seleccionar = false;

	baseDatos.addManejadorEventos("onAll", function(args) {
		$scope.lista = args;
		$scope.$apply();
	});
	baseDatos.addManejadorEventos("onError", function(args) {
		alert(args);
	});
	baseDatos.addManejadorEventos("onCreate", function(args) {
	});
	baseDatos.addManejadorEventos("onDelete", function(args) {
		baseDatos.getAll();
	});

	$scope.getAll = function() {
		baseDatos.getAll();
	};
	$scope.getAll();
});
