package org.upiicsa.web.model.Presupuesto.ManoObra;

import org.upiicsa.web.model.ProductoView;

public class CostoXActividad {
	
	private ProductoView producto;
	private Float unidadesaProducir;
	private Float horaxUnidad;
	private Float horasTotales;
	private Float cuota;
	private Float importe;
	
	
	
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	public Float getUnidadesaProducir() {
		return unidadesaProducir;
	}
	public void setUnidadesaProducir(Float unidadesaPrucir) {
		unidadesaProducir = unidadesaPrucir;
	}
	public Float getHoraxUnidad() {
		return horaxUnidad;
	}
	public void setHoraxUnidad(Float horaxUnidad) {
		this.horaxUnidad = horaxUnidad;
	}
	public Float getHorasTotales() {
		return horasTotales;
	}
	public void setHorasTotales(Float horasTotales) {
		this.horasTotales = horasTotales;
	}
	public Float getCuota() {
		return cuota;
	}
	public void setCuota(Float cuota) {
		this.cuota = cuota;
	}
	public ProductoView getProducto() {
		return producto;
	}
	public void setProducto(ProductoView producto) {
		this.producto = producto;
	}
	
	

}
