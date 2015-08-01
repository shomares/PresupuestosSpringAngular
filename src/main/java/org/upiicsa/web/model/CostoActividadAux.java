package org.upiicsa.web.model;

import java.io.Serializable;

public class CostoActividadAux implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Float couta;
	private String producto;
	private Float horas;
	private Integer idProducto;
	
	
	
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Float getCouta() {
		return couta;
	}
	public void setCouta(Float couta) {
		this.couta = couta;
	}
	public Float getHoras() {
		return horas;
	}
	public void setHoras(Float horas) {
		this.horas = horas;
	}
	
	
}
