package org.upiicsa.web.model.Presupuesto.PresupuestoVenta;

import org.upiicsa.web.model.ProductoView;

public class PresupuestoVentaDetalle {
	
	private ProductoView producto;
	private Float importe;
	private Float precioUnitario;
	private Float unidades;
	
	
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
	public Float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Float getUnidades() {
		return unidades;
	}
	public void setUnidades(Float unidades) {
		this.unidades = unidades;
	}
	

}
