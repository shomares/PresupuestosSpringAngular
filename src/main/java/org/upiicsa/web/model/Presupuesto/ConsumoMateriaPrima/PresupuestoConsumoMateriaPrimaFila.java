package org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima;

import java.io.Serializable;
import java.util.List;

import org.upiicsa.web.model.ProductoView;

public class PresupuestoConsumoMateriaPrimaFila  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductoView producto;
	private Float unidadesAProducir;
	private Float total;
	
	public List<PresupuestoConsumoMateriaXMateria> consumos;

	public ProductoView getProducto() {
		return producto;
	}

	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}

	public Float getUnidadesAProducir() {
		return unidadesAProducir;
	}

	public void setUnidadesAProducir(Float unidadesAProducir) {
		this.unidadesAProducir = unidadesAProducir;
	}

	public List<PresupuestoConsumoMateriaXMateria> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<PresupuestoConsumoMateriaXMateria> consumos) {
		this.consumos = consumos;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	
	
	
}
