package org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima;

import java.util.List;

import org.upiicsa.web.model.MateriaPrimaView;

public class ValuacionMateriaPrima {

	private MateriaPrimaView materiaPrima;
	
	private Float total;
	
	private List<ProductoValuacion>  productoValuacion;

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

	public List<ProductoValuacion> getProductoValuacion() {
		return productoValuacion;
	}

	public void setProductoValuacion(List<ProductoValuacion> productoValuacion) {
		this.productoValuacion = productoValuacion;
	}
	
	
	
	
}
