/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

var app = angular.module('presupuestos', []);

app.controller('ctrlEditarBalanceGeneral', function($scope, $location) {

	$.post("BalanceGeneral/Get", function(salida) {
		if (salida === undefined)
			alert("No se ha podido contactar con el servidor");
		else {
			$scope.objeto = salida;
			$scope.$apply();
		}
	});

	$scope.enviar = function() {
		$.postJSON("BalanceGeneral/inserta", $scope.objeto, function(salida) {
			if (salida.resultado !== "OK")
				alert(salida.resultado);
			else
				alertify.alert("Se ha guardado el balance general");
		});

	};

});
