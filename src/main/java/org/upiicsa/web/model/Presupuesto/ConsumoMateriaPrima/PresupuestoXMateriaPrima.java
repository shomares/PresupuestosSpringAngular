package org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima;

import org.upiicsa.web.model.MateriaPrimaView;

public class PresupuestoXMateriaPrima {
	private MateriaPrimaView materiaPrima;
	private Float total;
	
	
	public MateriaPrimaView getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaView materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
	
}
