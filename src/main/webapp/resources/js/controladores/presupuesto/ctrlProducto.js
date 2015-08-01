/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

var app = angular.module('presupuestos', []);

app.controller('ctrlNuevoProducto', function($scope, $location) {
	var baseDatos = new DaoGeneral("Producto");
	var id;

	id = $location.search().id;

	baseDatos.addManejadorEventos("onInsert", function(args) {
		window.history.back();
	});

	baseDatos.addManejadorEventos("onUpdate", function(args) {
		window.history.back();
	});
	baseDatos.addManejadorEventos("onGetById", function(args) {
		$scope.producto = args;
		$scope.$apply();
	});

	if (id !== undefined)
		baseDatos.geById(id);

	$scope.enviar = function() {
		if (id === undefined)
			baseDatos.pushObject($scope.producto);
		else
			baseDatos.update($scope.producto);
	};

});

app.controller('ctrlEditarProducto', function($scope) {
	var baseDatos = new DaoGeneral("Producto");

	$scope.seleccionar = false;

	baseDatos.addManejadorEventos("onAll", function(args) {
		$scope.productos = args;
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
		alertify.confirm("Desea eliminar el producto", function() {
			baseDatos.remove(idMateriaPrima);
		}, function() {
			alertify.error('No se ha borrado');
		});
	};
	$scope.eliminarTodos = function() {
		var aBorrar = new Array();

		alertify.confirm("Desea eliminar los productos selecionados",
				function() {
					for (var i = 0; i < $scope.productos.length; i++) {
						if ($scope.productos[i].selected)
							aBorrar.push($scope.productos[i].id);
					}
					baseDatos.removeAll(aBorrar);
				});
	};

	$scope.seleccionarTodos = function() {
		for (var i = 0; i < $scope.productos.length; i++)
			$scope.productos[i].selected = $scope.seleccionar;
	};

	$scope.nuevo = function() {
		window.location.href = "Producto/Editar";
	};

	$scope.getAll();
});
