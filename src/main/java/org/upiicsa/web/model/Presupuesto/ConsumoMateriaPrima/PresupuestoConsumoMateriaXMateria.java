package org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima;

import java.io.Serializable;

import org.upiicsa.web.model.MateriaPrimaView;

public class PresupuestoConsumoMateriaXMateria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MateriaPrimaView materiaPrima;
	private Float consumoUnidades;
	private Float unidadesConsumo;
	
	public MateriaPrimaView getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaView materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public Float getConsumoUnidades() {
		return consumoUnidades;
	}
	public void setConsumoUnidades(Float consumoUnidades) {
		this.consumoUnidades = consumoUnidades;
	}
	public Float getUnidadesConsumo() {
		return unidadesConsumo;
	}
	public void setUnidadesConsumo(Float unidadesConsumo) {
		this.unidadesConsumo = unidadesConsumo;
	}
	
	
	

}
