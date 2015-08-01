package org.upiicsa.web.model;

import java.io.Serializable;

public class CostoActividadView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actividad;
	private Integer id;
	
	private CostoActividadAux[] costoActividadAux;
	
	
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CostoActividadAux[] getCostoActividadAux() {
		return costoActividadAux;
	}
	public void setCostoActividadAux(CostoActividadAux[] costoActividadAux) {
		this.costoActividadAux = costoActividadAux;
	}
	
	
	

}
