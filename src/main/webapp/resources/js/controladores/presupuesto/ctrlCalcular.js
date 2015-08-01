/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";

var app = angular.module('presupuestos', []);

app.controller('ctrlCalcular', function($scope, $location) {
	
	var  loader;
	addEventListener('load', load, false);
    function load(){
    	loader= document.getElementById("loader");
    }
	
	$scope.habilitado='none';
	
		$scope.pregunta= function(){
			$.get("Presupuesto/GetAvance", function(salida) {
				if (salida.resultado === "OK"){
					loader.innerHTML = "";
					alertify.alert("Se ha generado el reporte");
					
					window.location.href = "Presupuesto/GetPresupuesto";
				}
				else if (salida.resultado=="NO"){
					$scope.$apply();
					window.setTimeout(function(){
						$scope.pregunta();
					}, 200);
				}else
					{
						alertify.alert("Ha surgido un error grave");
						loader.innerHTML = "";
						
					
					}
			});
			
		};
	
		$scope.enviar= function(){
			$.get("Presupuesto/Calcular", function(salida) {
				if (salida === undefined)
					alert("No se ha podido contactar con el servidor");
				else {
					loader.innerHTML = "<div class='progress'> <div class='indeterminate'></div></div>";
						    window.setTimeout(function(){
						$scope.pregunta();
					}, 200);
				}
			});
		};


	});
	
			
		