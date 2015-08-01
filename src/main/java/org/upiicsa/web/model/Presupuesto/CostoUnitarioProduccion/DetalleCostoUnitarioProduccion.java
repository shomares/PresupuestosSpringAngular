package org.upiicsa.web.model.Presupuesto.CostoUnitarioProduccion;

import org.upiicsa.web.model.ProductoView;

public class DetalleCostoUnitarioProduccion {

	
	private ProductoView producto;
	private Float materiaPrimaDirecta;
	private Float manodeObraDirecta;
	private Float  cargosIndirectos;
	private Float 	unidades;
	private Float costoUnitario;
	private Float preciodeVenta;
	private Float suma;
	
	
	
	
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	public Float getMateriaPrimaDirecta() {
		return materiaPrimaDirecta;
	}
	public void setMateriaPrimaDirecta(Float materiaPrimaDirecta) {
		this.materiaPrimaDirecta = materiaPrimaDirecta;
	}
	public Float getManodeObraDirecta() {
		return manodeObraDirecta;
	}
	public void setManodeObraDirecta(Float manodeObraDirecta) {
		this.manodeObraDirecta = manodeObraDirecta;
	}
	public Float getCargosIndirectos() {
		return cargosIndirectos;
	}
	public void setCargosIndirectos(Float cargosIndirectos) {
		this.cargosIndirectos = cargosIndirectos;
	}
	public Float getUnidades() {
		return unidades;
	}
	public void setUnidades(Float unidades) {
		this.unidades = unidades;
	}
	public Float getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Float costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public Float getPreciodeVenta() {
		return preciodeVenta;
	}
	public void setPreciodeVenta(Float preciodeVenta) {
		this.preciodeVenta = preciodeVenta;
	}
	public Float getSuma() {
		return suma;
	}
	public void setSuma(Float suma) {
		this.suma = suma;
	}
	
	
	

}
