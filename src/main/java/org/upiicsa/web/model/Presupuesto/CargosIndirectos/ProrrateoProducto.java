package org.upiicsa.web.model.Presupuesto.CargosIndirectos;

import org.upiicsa.web.model.ProductoView;

public class ProrrateoProducto {
	private ProductoView producto;
	private Float importe;
	private Float horas;
	
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	public Float getHoras() {
		return horas;
	}
	public void setHoras(Float horas) {
		this.horas = horas;
	}
	
	
	

}
