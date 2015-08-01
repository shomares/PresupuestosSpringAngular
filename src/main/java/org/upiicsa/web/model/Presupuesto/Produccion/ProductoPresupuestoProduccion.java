package org.upiicsa.web.model.Presupuesto.Produccion;

import org.upiicsa.web.model.ProductoView;

public class ProductoPresupuestoProduccion {

	private ProductoView producto;
	private Integer unidadesaAVender;
	private Float inventarioFinalDeseado;
	private Float necesidadTotal;
	private Float  inventarioTotal;
	private Float unidadesaProducir;
	
	
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	public Integer getUnidadesaAVender() {
		return unidadesaAVender;
	}
	public Float getInventarioFinalDeseado() {
		return inventarioFinalDeseado;
	}
	public void setInventarioFinalDeseado(Float inventarioFinalDeseado) {
		this.inventarioFinalDeseado = inventarioFinalDeseado;
	}
	public Float getNecesidadTotal() {
		return necesidadTotal;
	}
	public void setNecesidadTotal(Float necesidadTotal) {
		this.necesidadTotal = necesidadTotal;
	}
	public Float getInventarioTotal() {
		return inventarioTotal;
	}
	public void setInventarioTotal(Float inventarioTotal) {
		this.inventarioTotal = inventarioTotal;
	}
	public Float getUnidadesaProducir() {
		return unidadesaProducir;
	}
	public void setUnidadesaProducir(Float unidadesaProducir) {
		this.unidadesaProducir = unidadesaProducir;
	}
	public void setUnidadesaAVender(Integer unidadesaAVender) {
		this.unidadesaAVender = unidadesaAVender;
	}
	
	
	
}
