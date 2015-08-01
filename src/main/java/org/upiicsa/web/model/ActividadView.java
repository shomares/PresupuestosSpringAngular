package org.upiicsa.web.model;

import java.io.Serializable;


public class ActividadView implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private String descripcion;

	private Float cargoIndirecto;
	
	
	private Float valesMantenimiento;
	
	private Float valesAlmacen;
	

	
	
	public Float getValesMantenimiento() {
		return valesMantenimiento;
	}

	public void setValesMantenimiento(Float valesMantenimiento) {
		this.valesMantenimiento = valesMantenimiento;
	}

	public Float getValesAlmacen() {
		return valesAlmacen;
	}

	public void setValesAlmacen(Float valesAlmacen) {
		this.valesAlmacen = valesAlmacen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getCargoIndirecto() {
		return cargoIndirecto;
	}

	public void setCargoIndirecto(Float cargoIndirecto) {
		this.cargoIndirecto = cargoIndirecto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
