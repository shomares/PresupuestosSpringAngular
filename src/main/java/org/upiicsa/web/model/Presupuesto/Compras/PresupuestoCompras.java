package org.upiicsa.web.model.Presupuesto.Compras;

import java.io.Serializable;
import java.util.List;

import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.upiicsa.web.model.Presupuesto.IPresupuestoModel;

public class PresupuestoCompras implements Serializable, IPresupuestoModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<LineaPresupuestoCompras> lineas;
	private Float total;

	public List<LineaPresupuestoCompras> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaPresupuestoCompras> lineas) {
		this.lineas = lineas;
	}

	public void setTotal(Float total) {
		// TODO Auto-generated method stub
		this.total= total;
	}
	public Float getTotal() {
		return total;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
