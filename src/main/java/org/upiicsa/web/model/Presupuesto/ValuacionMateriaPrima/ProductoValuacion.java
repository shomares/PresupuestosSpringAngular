package org.upiicsa.web.model.Presupuesto.ValuacionMateriaPrima;

import org.upiicsa.web.model.ProductoView;

public class ProductoValuacion {
	private ProductoView producto;
	private Float unidadConsumidad;
	
	private Float mezclaInventarioInicial;
	private Float mezclaInventarioFinal;
	
	private Float costoUnidadInicial;
	private Float costoUnidadFinal;
	
	private Float importeInicial;
	private Float importeFinal;
	
	private Float importeTotal;
	
	
	
	public Float getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	public Float getUnidadConsumidad() {
		return unidadConsumidad;
	}
	public void setUnidadConsumidad(Float unidadConsumidad) {
		this.unidadConsumidad = unidadConsumidad;
	}
	public Float getMezclaInventarioInicial() {
		return mezclaInventarioInicial;
	}
	public void setMezclaInventarioInicial(Float mezclaInventarioInicial) {
		this.mezclaInventarioInicial = mezclaInventarioInicial;
	}
	public Float getMezclaInventarioFinal() {
		return mezclaInventarioFinal;
	}
	public void setMezclaInventarioFinal(Float mezclaInventarioFinal) {
		this.mezclaInventarioFinal = mezclaInventarioFinal;
	}
	public Float getCostoUnidadInicial() {
		return costoUnidadInicial;
	}
	public void setCostoUnidadInicial(Float costoUnidadInicial) {
		this.costoUnidadInicial = costoUnidadInicial;
	}
	public Float getCostoUnidadFinal() {
		return costoUnidadFinal;
	}
	public void setCostoUnidadFinal(Float costoUnidadFinal) {
		this.costoUnidadFinal = costoUnidadFinal;
	}
	public Float getImporteInicial() {
		return importeInicial;
	}
	public void setImporteInicial(Float importeInicial) {
		this.importeInicial = importeInicial;
	}
	public Float getImporteFinal() {
		return importeFinal;
	}
	public void setImporteFinal(Float importeFinal) {
		this.importeFinal = importeFinal;
	}
	
	
	
	
	
}
