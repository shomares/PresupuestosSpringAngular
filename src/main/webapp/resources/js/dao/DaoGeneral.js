/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

function DaoGeneral(controlador) {
	this.onInsert = new Eventos("onInsert");
	this.onDelete = new Eventos("onDelete");
	this.onUpdate = new Eventos("onUpdate");
	this.onAll = new Eventos("onAll");
	this.onError = new Eventos("onError");
	this.onGetById= new Eventos("onGetById");
	this.controlador= controlador;
}
DaoGeneral.prototype= new ConEventos();

DaoGeneral.prototype.pushObject = function(datos) {
	var root = this;
	$.postJSON("inserta", 
		datos
	, function(salida) {
		if (salida.resultado !== "OK")
			root.onError.onEvent(salida.resultado);
		else
			root.onInsert.onEvent();
	});
};

DaoGeneral.prototype.getAll = function() {
	var root = this;
	$.post(this.controlador+"/All", function(salida) {
		if (salida === undefined)
			root.onError.onEvent("No se pudo contatactar el servidor");
		else
			root.onAll.onEvent(salida);
	});
};
DaoGeneral.prototype.remove = function(id) {
	var root = this;
	$.postJSON(this.controlador+"/Delete", 
		id
	, function(salida) {
		if (salida.resultado !== "OK")
			root.onError.onEvent(salida.resultado);
		else
			root.onDelete.onEvent();
	});
};
DaoGeneral.prototype.removeAll = function(ids) {
	var root = this;
	$.postJSON(this.controlador+"/DeleteAll", 
		ids
	, function(salida) {
		if (salida.resultado !== "OK")
			root.onError.onEvent("No se pudo contatactar el servidor");
		else
			root.onDelete.onEvent();
	});

};
DaoGeneral.prototype.geById= function(id){
	var root= this;
	$.postJSON("Id", 
			id
		, function(salida) {
			if (salida ===  undefined)
				root.onError.onEvent("No se pudo contactar el servidor");
			else
				root.onGetById.onEvent(salida);
		});
};
DaoGeneral.prototype.update= function(datos) {
	var root = this;
	$.postJSON("inserta", 
		datos
	, function(salida) {
		if (salida.resultado !== "OK")
			root.onError.onEvent(salida.resultado);
		else
			root.onUpdate.onEvent();
	});
};


