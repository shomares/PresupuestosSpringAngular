/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";


/** Clase evento.
 * @constructor
 * @returns {Eventos} 
 * @argument {string} name Nombre del Evento*/
function Eventos(name) {
    this.name = name;
}
//La funcion eventos hereda de Array
Eventos.prototype = new Array();
Eventos.prototype.constructor = Eventos;
//Le agregamos la funcionalidad
Eventos.prototype.addEvent = function (args) {
    if (typeof (args) === 'function')
        this.push(args);
};
Eventos.prototype.onEvent = function () {
    var args = arguments;
    this.forEach(function (arg) {
        arg.apply(null, args);
    });
};

/**
 * @constructor 
 * @returns {ConEventos}
 */

function ConEventos() {
}
ConEventos.prototype.addManejadorEventos = function ( nombre , funcion) {
    var props = Object.getOwnPropertyNames(this);
    for (var i = 0; i < props.length; i++) {
        if ((this[props[i]]) instanceof  Eventos && this[props[i]].name === nombre)
            this[props[i]].addEvent(funcion);
    }
};
/**Especial*/
Array.prototype.contains = function(obj) {
    var i = this.length;
    while (i--) {
        if (this[i] === obj) {
            return true;
        }
    }
    return false;
};















