package org.upiicsa.web.model;

import java.io.Serializable;

public class UsoMateriaPorProductoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProducto;
	private String nombre;
	private UsoAuxiliarView[] usomateria;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UsoAuxiliarView[] getUsomateria() {
		return usomateria;
	}

	public void setUsomateria(UsoAuxiliarView[] usomateria) {
		this.usomateria = usomateria;
	}

}
