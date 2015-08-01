package org.upiicsa.web.model;

import java.io.Serializable;



public class ProductoView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer id;


	private String nombre;

	private Float cantidadInventarioInicial;
	
	private Float cantidadInventarioFinal;
	
	private Float costoInicial;

	
	private Integer unidades;
	

	
	public Integer getId() {
		return id;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getCantidadInventarioInicial() {
		return cantidadInventarioInicial;
	}

	public void setCantidadInventarioInicial(Float cantidadInventarioInicial) {
		this.cantidadInventarioInicial = cantidadInventarioInicial;
	}

	public Float getCantidadInventarioFinal() {
		return cantidadInventarioFinal;
	}

	public void setCantidadInventarioFinal(Float cantidadInventarioFinal) {
		this.cantidadInventarioFinal = cantidadInventarioFinal;
	}

	public Float getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(Float costoInicial) {
		this.costoInicial = costoInicial;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}


}
