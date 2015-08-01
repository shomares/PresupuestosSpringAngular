package org.upiicsa.web.model.Presupuesto.CargosIndirectos;

import org.upiicsa.web.model.ActividadView;

public class ProrrateoSecundario {
	private Float montoPorrateo;
	private ActividadView actividad;
	
	public Float getMontoPorrateo() {
		return montoPorrateo;
	}
	public void setMontoPorrateo(Float montoPorrateo) {
		this.montoPorrateo = montoPorrateo;
	}
	public ActividadView getActividad() {
		return actividad;
	}
	public void setActividad(ActividadView actividad) {
		this.actividad = actividad;
	}
	
	
}
