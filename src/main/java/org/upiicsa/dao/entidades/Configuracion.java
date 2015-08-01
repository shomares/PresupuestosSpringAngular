package org.upiicsa.dao.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.upiicsa.dao.IEntity;

@Entity
public class Configuracion implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Float porcientoCostoProduccionXVenta;

	@Column
	private Float gastoAdministracion;

	@Column
	private Float gastoVentas;

	@Column
	private Float costoMantenimiento;

	@Column
	private Float reparticionDividendos;
	@Column
	private Float ventasDePeriodo;
	@Column
	private Float procientoPagoCompra;
	
	
	

	public Float getCostoAlmacen() {
		return costoAlmacen;
	}

	public void setCostoAlmacen(Float costoAlmacen) {
		this.costoAlmacen = costoAlmacen;
	}

	@Column
	private Float costoAlmacen;

	@Column
	private Float numeroValesMantenimiento;

	@Column
	private Float numeroValesAlmacen;

	@Column
	private Float numeroValesAlmacenManto;

	public Float getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public void setCostoMantenimiento(Float costoMantenimiento) {
		this.costoMantenimiento = costoMantenimiento;
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

	public Float getGastoAdministracion() {
		return gastoAdministracion;
	}

	public void setGastoAdministracion(Float gastoAdministracion) {
		this.gastoAdministracion = gastoAdministracion;
	}

	public Float getGastoVentas() {
		return gastoVentas;
	}

	public void setGastoVentas(Float gastoVentas) {
		this.gastoVentas = gastoVentas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
