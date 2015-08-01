package org.upiicsa.web.model;

import java.io.Serializable;

import javax.persistence.Column;


public class ConfiguracionView  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Float porcientoCostoProduccionXVenta;
	
	
	private Float montoAdministracion;
	
	private Float montoVenta;
	
	
	private Float costoMantenimiento;
	
	private Float costoAlmacen;
	
	private Float numeroValesMantenimiento;
	
	private Float numeroValesAlmacen;
	
	private Float numeroValesAlmacenManto;

	private Float reparticionDividendos;
	private Float ventasDePeriodo;
	private Float procientoPagoCompra;
	
	
	
	

	public Float getReparticionDividendos() {
		return reparticionDividendos;
	}

	public void setReparticionDividendos(Float reparticionDividendos) {
		this.reparticionDividendos = reparticionDividendos;
	}

	public Float getVentasDePeriodo() {
		return ventasDePeriodo;
	}

	public void setVentasDePeriodo(Float ventasDePeriodo) {
		this.ventasDePeriodo = ventasDePeriodo;
	}

	public Float getProcientoPagoCompra() {
		return procientoPagoCompra;
	}

	public void setProcientoPagoCompra(Float procientoPagoCompra) {
		this.procientoPagoCompra = procientoPagoCompra;
	}

	public Float getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public void setCostoMantenimiento(Float costoMantenimiento) {
		this.costoMantenimiento = costoMantenimiento;
	}


	public Float getCostoAlmacen() {
		return costoAlmacen;
	}

	public void setCostoAlmacen(Float costoAlmacen) {
		this.costoAlmacen = costoAlmacen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Float getNumeroValesMantenimiento() {
		return numeroValesMantenimiento;
	}

	public void setNumeroValesMantenimiento(Float numeroValesMantenimiento) {
		this.numeroValesMantenimiento = numeroValesMantenimiento;
	}

	public Float getNumeroValesAlmacen() {
		return numeroValesAlmacen;
	}

	public void setNumeroValesAlmacen(Float numeroValesAlmacen) {
		this.numeroValesAlmacen = numeroValesAlmacen;
	}

	public Float getNumeroValesAlmacenManto() {
		return numeroValesAlmacenManto;
	}

	public void setNumeroValesAlmacenManto(Float numeroValesAlmacenManto) {
		this.numeroValesAlmacenManto = numeroValesAlmacenManto;
	}

	public Float getMontoAdministracion() {
		return montoAdministracion;
	}

	public void setMontoAdministracion(Float montoAdministracion) {
		this.montoAdministracion = montoAdministracion;
	}

	public Float getMontoVenta() {
		return montoVenta;
	}

	public void setMontoVenta(Float montoVenta) {
		this.montoVenta = montoVenta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPorcientoCostoProduccionXVenta() {
		return porcientoCostoProduccionXVenta;
	}

	public void setPorcientoCostoProduccionXVenta(Float porcientoCostoProduccionXVenta) {
		this.porcientoCostoProduccionXVenta = porcientoCostoProduccionXVenta;
	}
	
	

}
