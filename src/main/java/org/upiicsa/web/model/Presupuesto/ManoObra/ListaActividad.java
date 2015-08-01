package org.upiicsa.web.model.Presupuesto.ManoObra;

import java.io.Serializable;
import java.util.List;

import org.upiicsa.web.model.ActividadView;

public class ListaActividad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CostoXActividad> costos;
	private ActividadView actividad;
	
	public List<CostoXActividad> getCostos() {
		return costos;
	}
	public void setCostos(List<CostoXActividad> costo) {
		this.costos = costo;
	}
	public ActividadView getActividad() {
		return actividad;
	}
	public void setActividad(ActividadView actividad) {
		this.actividad = actividad;
	}
	
	
	
	
	
	

}
