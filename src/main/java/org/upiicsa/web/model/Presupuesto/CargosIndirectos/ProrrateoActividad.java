package org.upiicsa.web.model.Presupuesto.CargosIndirectos;

import java.util.List;

import org.upiicsa.web.model.ActividadView;

public class ProrrateoActividad {

	private ActividadView actividad;
	private Float importeTotal;
	private List<ProrrateoProducto> prorrateoProducto;
	public ActividadView getActividad() {
		return actividad;
	}
	public void setActividad(ActividadView actividad) {
		this.actividad = actividad;
	}
	public Float getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}
	public List<ProrrateoProducto> getProrrateoProducto() {
		return prorrateoProducto;
	}
	public void setProrrateoProducto(List<ProrrateoProducto> prorrateoProducto) {
		this.prorrateoProducto = prorrateoProducto;
	}
	
	
	
	
}
