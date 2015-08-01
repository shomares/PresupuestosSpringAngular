package org.upiicsa.web.model;

import java.io.Serializable;

public class AvanceView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Float avance;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getAvance() {
		return avance;
	}

	public void setAvance(Float avance) {
		this.avance = avance;
	}

}
