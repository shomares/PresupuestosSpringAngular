package org.upiicsa.web.model.Presupuesto.Compras;

import java.io.Serializable;

import org.upiicsa.web.model.MateriaPrimaView;

public class LineaPresupuestoCompras implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MateriaPrimaView materiaPrima;
	private Float  unidadesConsumir;
	private Float inventarioFinalDeseado;
	private Float necesidadTotal;
	private Float inventarioInicial;
	private Float unidadesaComprar;
	private Float costoXUnidad;
	private Float importe;
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public MateriaPrimaView getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaView materiaPrima) {
		this.materiaPrima = materiaPrima;
		this.nombre= materiaPrima.getNombre();
	}
	public Float getUnidadesConsumir() {
		return unidadesConsumir;
	}
	public void setUnidadesConsumir(Float unidadesConsumir) {
		this.unidadesConsumir = unidadesConsumir;
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
	public Float getInventarioInicial() {
		return inventarioInicial;
	}
	public void setInventarioInicial(Float inventarioInicial) {
		this.inventarioInicial = inventarioInicial;
	}
	public Float getUnidadesaComprar() {
		return unidadesaComprar;
	}
	public void setUnidadesaComprar(Float unidadesaComprar) {
		this.unidadesaComprar = unidadesaComprar;
	}
	public Float getCostoXUnidad() {
		return costoXUnidad;
	}
	public void setCostoXUnidad(Float costoXUnidad) {
		this.costoXUnidad = costoXUnidad;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	
	
}
