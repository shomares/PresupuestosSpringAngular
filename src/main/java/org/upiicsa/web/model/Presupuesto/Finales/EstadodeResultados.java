package org.upiicsa.web.model.Presupuesto.Finales;

import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class EstadodeResultados implements IPresupuestoModel{

	private Float ventas;
	private Float costoVentas;
	private Float utilidadBruta;
	private Float gastosOperacion;
	private Float utantes;
	private Float isr;
	private Float utilidadEjercicio;

	public Float getVentas() {
		return ventas;
	}

	public void setVentas(Float ventas) {
		this.ventas = ventas;
	}
 
	public Float getCostoVentas() {
		return costoVentas;
	}

	public void setCostoVentas(Float costoVentas) {
		this.costoVentas = costoVentas;
	}

	public Float getUtilidadBruta() {
		return utilidadBruta;
	}

	public void setUtilidadBruta(Float utilidadBruta) {
		this.utilidadBruta = utilidadBruta;
	}

	public Float getGastosOperacion() {
		return gastosOperacion;
	}

	public void setGastosOperacion(Float gastosOperacion) {
		this.gastosOperacion = gastosOperacion;
	}

	public Float getUtantes() {
		return utantes;
	}

	public void setUtantes(Float utantes) {
		this.utantes = utantes;
	}

	public Float getIsr() {
		return isr;
	}

	public void setIsr(Float isr) {
		this.isr = isr;
	}

	public Float getUtilidadEjercicio() {
		return utilidadEjercicio;
	}

	public void setUtilidadEjercicio(Float utilidadEjercicio) {
		this.utilidadEjercicio = utilidadEjercicio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
