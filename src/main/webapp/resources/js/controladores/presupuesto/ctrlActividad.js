/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

var app = angular.module('presupuestos', []);

app.controller('ctrlNuevoActividad', function($scope, $location) {
	var baseDatos = new DaoGeneral("Actividad");
	var id;

	id = $location.search().id;

	baseDatos.addManejadorEventos("onInsert", function(args) {
		window.history.back();
	});

	baseDatos.addManejadorEventos("onUpdate", function(args) {
		window.history.back();
	});
	baseDatos.addManejadorEventos("onGetById", function(args) {
		$scope.objeto = args;
		$scope.$apply();
	});

	if (id !== undefined)
		baseDatos.geById(id);

	$scope.enviar = function() {
		if (id === undefined)
			baseDatos.pushObject($scope.objeto);
		else
			baseDatos.update($scope.objeto);
	};

});

app.controller('ctrlEditarActividad', function($scope) {
	var baseDatos = new DaoGeneral("Actividad");

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
	$scope.eliminar = function(idMateriaPrima) {
		alertify.confirm("Desea eliminar las actividades", function() {
			baseDatos.remove(idMateriaPrima);
		}, function() {
			alertify.error('No se ha borrado');
		});
	};
	$scope.eliminarTodos = function() {
		var aBorrar = new Array();

		alertify.confirm("Desea eliminar las actividades  seleccionadas",
				function() {
					for (var i = 0; i < $scope.lista.length; i++) {
						if ($scope.lista[i].selected)
							aBorrar.push($scope.lista[i].id);
					}
					baseDatos.removeAll(aBorrar);
				});
	};

	$scope.seleccionarTodos = function() {
		for (var i = 0; i < $scope.lista.length; i++)
			$scope.lista[i].selected = $scope.seleccionar;
	};

	$scope.nuevo = function() {
		window.location.href = "Actividad/Editar";
	};

	$scope.getAll();
});
