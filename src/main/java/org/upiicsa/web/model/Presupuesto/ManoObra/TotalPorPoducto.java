package org.upiicsa.web.model.Presupuesto.ManoObra;

import org.upiicsa.web.model.ProductoView;

public class TotalPorPoducto {
	private ProductoView producto;
	private Float total;
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
}
